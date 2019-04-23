package com.example.bsapp.mvp.model

import com.google.gson.*
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

data class Bs (

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

data class Links (
    @SerializedName ("indriver-debug-2928.apk") val indriver_debug_2928_apk: String
)


class BsList {

    @SerializedName("bs_list")
    private lateinit var bsList: List<Bs>

    fun getBsList(): List<Bs> {
        return bsList
    }

    fun setBsList(bsList: List<Bs>) {
        this.bsList = bsList
    }
}


class BsDeserializer : JsonDeserializer<BsList> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): BsList {
        val content: JsonElement = json?.asJsonObject!!.get("bslist")

        return  Gson().fromJson(content, BsList::class.java)
    }

}