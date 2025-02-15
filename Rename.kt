import java.io.File
import java.security.MessageDigest

fun main() {
    renameFiles()
//    deleteDuplicateFiles()
}

fun deleteDuplicateFiles(){
    val parentFolder = File("./Frames_1") // Change this to your folder path

    if (!parentFolder.exists() || !parentFolder.isDirectory) {
        println("Invalid folder path")
        return
    }

    val imageHashes = mutableMapOf<String, File>() // Map to store image hashes

    findAndRemoveDuplicates(parentFolder, imageHashes)
}
fun findAndRemoveDuplicates(folder: File, imageHashes: MutableMap<String, File>) {
    folder.listFiles()?.forEach { file ->
        if (file.isDirectory) {
            // Recursively check subfolders
            findAndRemoveDuplicates(file, imageHashes)
        } else if (isImageFile(file)) {
            val hash = getFileHash(file)
            if (imageHashes.containsKey(hash)) {
                println(">>>>>>>  Duplicate found: ${file.absolutePath} (same as ${imageHashes[hash]?.absolutePath})")
                file.delete() // Remove the duplicate
            } else {
                imageHashes[hash] = file
            }
        }
    }
}

// Function to check if a file is an image
fun isImageFile(file: File): Boolean {
    val extensions = listOf("jpg", "jpeg", "png", "gif", "bmp", "webp")
    return file.extension.lowercase() in extensions
}

// Function to compute a file's hash (SHA-256)
fun getFileHash(file: File): String {
    val digest = MessageDigest.getInstance("SHA-256")
    file.inputStream().use { input ->
        val buffer = ByteArray(1024)
        var bytesRead: Int
        while (input.read(buffer).also { bytesRead = it } != -1) {
            digest.update(buffer, 0, bytesRead)
        }
    }
    return digest.digest().joinToString("") { "%02x".format(it) }
}

fun renameFiles(){
    // Specify the folder path
    val folderPath = "./nature_scenery/stickers"

    // Specify the new name prefix
    val newNamePrefix = "sunsets_sticker_"

    // Access the folder
    val folder = File(folderPath)

    // Check if the folder exists and is a directory
    if (folder.exists() && folder.isDirectory) {
        // Get all files in the folder
        val files = folder.listFiles()

        if (files != null) {
            var counter = 0
            for (file in files) {
                if (file.isFile) {
                    // Get the file extension
                    val extension = file.extension

                    if (file.name.startsWith("sunset_sticker")){
                        // Construct the new file name
                        val newFileName = "$newNamePrefix${counter}.$extension"

                        // Rename the file
                        val renamedFile = File(folder, newFileName)
                        val success = file.renameTo(renamedFile)

                        // Print the result
                        if (success) {
                            println("Renamed: ${file.name} -> ${renamedFile.name}")
                            counter++
                        } else {
                            println("Failed to rename: ${file.name}")
                        }
                    }
                }
            }
        } else {
            println("No files found in the folder.")
        }
    } else {
        println("The specified path is not a valid folder.")
    }
}
