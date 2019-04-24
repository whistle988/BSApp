package com.example.bsapp.model


import com.google.gson.annotations.SerializedName

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

data class Links (
    @SerializedName ("indriver-debug-2928.apk") val indriver_debug_2928_apk: String
)



