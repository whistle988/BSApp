package com.example.bsapp

import android.support.annotation.NonNull
import android.support.annotation.Nullable
import com.google.gson.*
import retrofit2.Converter
import retrofit2.Converter.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type


class Links {

    val links: Map<String, String>? = null
}

internal class LinksUrlDeserializer : JsonDeserializer<Links> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Links {
        val jsonObject = json.asJsonObject
        // Read the dynamic links object.
        val linksPair = readlinksMap(jsonObject)
        val result = Links()
        result.links
        return result
    }

    @Nullable
    private fun readlinksMap(@NonNull jsonObject: JsonObject): Map<String, String>? {
        val linksElement = jsonObject.get(KEY_LINKS)
            if (linksElement == null){
                // value not present at all, just return null
                return null
            }


        val linksObject = linksElement.asJsonObject
        val links: MutableMap<String, String> = HashMap()
        for (entry in linksObject.entrySet())
        {
            val key = entry.key
            val value = entry.value.asString
            links.put(key, value)
        }
        return links
    }

    companion object {


        private val KEY_LINKS = "links"
    }


}