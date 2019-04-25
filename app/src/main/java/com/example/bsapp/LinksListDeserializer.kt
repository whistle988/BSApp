/*
package com.example.bsapp

import android.support.annotation.NonNull
import android.support.annotation.Nullable
import com.example.bsapp.model.Links
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import java.lang.reflect.Type


class LinksListDeserializer : JsonDeserializer<Links> {



    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Links {
        val jsonObject = json.asJsonObject
        val exchangePairs: Map<String, String> = readPairMap(jsonObject)
        val result = Links()
        result.linksPairs
        return result
    }

    @Nullable
    private fun readPairMap(@NonNull jsonObject: JsonObject): Map<String, String> {
        // Initializing Hashmap for the outer object
        val result: MutableMap<String, String> = HashMap()

        for ((exchange, value) in jsonObject.entrySet()) {
            var fromSymbol: String
            var toSymbols: Array<String>?
            val fsymbolObj = value.asJsonObject

            // Initializing Hashmap for inner objects
            //val pairsPerCoin: MutableMap<String, String> = HashMap()

            for ((key, value1) in fsymbolObj.entrySet()) {
                fromSymbol = key
                toSymbols = toStringArray(value1.asJsonArray)
                pairsPerCoin.put(fromSymbol, toSymbols)
            }
            result.put(exchange, pairsPerCoin)
        }
        return result
    }

    companion object {

        private val TAG = PairListDeserializer::class.java.simpleName

        private fun toStringArray(array: JsonArray?): Array<String>? {
            if (array == null) return null
            val arr = arrayOfNulls<String>(array.size())
            for (i in arr.indices) {
                arr[i] = array.get(i).toString()
            }
            return arr
        }
    }
}*/
