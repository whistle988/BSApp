package com.example.bsapp.model


import com.example.bsapp.Links
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.annotations.SerializedName

import java.lang.reflect.Type

object BsList {

    data class Bs(

        @SerializedName("finish_date")
        val finish_date: String,
        @SerializedName("links")
        val links: Links,
        @SerializedName("build_number")
        val build_number: String,
        @SerializedName("branch")
        val branch: String,
        @SerializedName("target_system")
        val target_system: String,
        @SerializedName("build_id")
        val build_id: String,
        @SerializedName("playmarket")
        val playmarket: Boolean
        )
}

//data class Links (val indriver_debug: String)

/*class Links {

    var linksPairs: Map<String, String>? = null*/

    /*fun getTradingPairs(fromSymbol: String): Map<String, String> {
        return exchangePairs.get(fromSymbol)
    }*/



/*
class CustomDeserializer: JsonDeserializer<List<Map<Int, String>>> {
    @Throws(JsonParseException::class)
    fun deserialize(element: JsonElement, typeOfT: Type, context: JsonDeserializationContext):List<Map<Int, String>> {
        val randomList = ArrayList()
        val parentJsonObject = element.getAsJsonObject()
        val childMap:Map<Int, String>
        for (entry in parentJsonObject.entrySet())
        {
            childMap = HashMap()
            for (entry1 in entry.getValue().getAsJsonObject().entrySet())
            {
                childMap.put(Integer.parseInt(entry1.getKey()), entry1.getValue().toString())
            }
            randomList.add(childMap)
        }
        return randomList
    }
}*/


/*
class ExampleItem(imageResource:Int, text1:String, text2:String) {
    val imageResource:Int = 0
    val text1:String
    val text2:String
    init{
        this.imageResource = imageResource
        this.text1 = text1
        this.text2 = text2
    }
}*/




