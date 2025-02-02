import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectOutputStream
import java.util.Date
/*

fun uploadDataOnServer() {
    try {
        val mainObject: JSONObject = JSONObject()
        val jsonArray: JSONArray = JSONArray()
        val a: Array<String> = getContext().getResources().getStringArray(R.array.categories)
        for (i in a.indices) {
            val catObject: JSONObject = JSONObject()
            catObject.put("name", a[i])
            catObject.put("position", i)
            catObject.put("isAvailable", true)
            val types: Array<String> = AssetUtils.getTypeOfFrames(a[i])
            val typesArray: JSONArray = JSONArray()
            for (j in types.indices) {
                val typeObject: JSONObject = JSONObject()
                typeObject.put("name", types[j])
                typeObject.put("position", j)
                typeObject.put("isAvailable", true)
                val framesArray: JSONArray = JSONArray()
                val stickersArray: JSONArray = JSONArray()
                for (k in 0..19) {
                    val frame: JSONObject = JSONObject()
                    val sticker: JSONObject = JSONObject()
                    frame.put(
                        "name",
                        AssetUtils.getFrameName(a[i] + "_" + types[j] + "_" + k + ".webp")
                    )
                    frame.put("position", k)
                    frame.put("isAvailable", true)
                    sticker.put(
                        "name",
                        AssetUtils.getFrameName(types[j] + "_sticker_" + k + ".webp")
                    )
                    sticker.put("position", k)
                    sticker.put("isAvailable", true)
                    framesArray.put(frame)
                    stickersArray.put(sticker)
                }
                typeObject.put("frames", framesArray)
                typeObject.put("sticker", stickersArray)
                typesArray.put(typeObject)
                catObject.put("types", typesArray)
            }
            jsonArray.put(catObject)
        }
        mainObject.put("categories", jsonArray)
        saveListToFile(mainObject)
    } catch (e: JSONException) {
        Log.e("######", e.toString())
    }
}

fun saveListToFile(stringList: JSONObject) {
    Log.e("######## JSon >>", stringList.toString())
    var fos: FileOutputStream? = null
    var oos: ObjectOutputStream? = null
    try {
        // Open a file output stream in your app's private directory

        val cacheFile: File = File(getCacheDir(), Date().time.toString() + ".json")

        Log.e("####### file path ", cacheFile.absolutePath)
        // Create FileOutputStream and ObjectOutputStream to write the JSON to the file
        fos = FileOutputStream(cacheFile)
        oos = ObjectOutputStream(fos)
        oos.writeObject(stringList.toString())

        Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
    } catch (e: IOException) {
        e.printStackTrace()
        Toast.makeText(this, "Error saving file", Toast.LENGTH_SHORT).show()
    } finally {
        try {
            oos?.close()
            fos?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}*/
