import java.io.File

fun main() {
    // Specify the folder path
    val folderPath = "./celebrations/stickers"

    // Specify the new name prefix
    val newNamePrefix = "birthdays_stickers"

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
        } else {
            println("No files found in the folder.")
        }
    } else {
        println("The specified path is not a valid folder.")
    }
}
