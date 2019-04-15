package com.example.bsapp

import com.google.gson.annotations.SerializedName

data class Bs (
    @SerializedName("build_number") val build_number: String,
    @SerializedName("branch") val branch: String,
    @SerializedName("target_system") val target_system: String,
    @SerializedName("playmarket") val playmarket: Boolean
    //@SerializedName("links") val links: Links
)

/*data class Links (
    @SerializedName ("indriver-debug-2928.apk") val indriver_debug_2928_apk: String
)*/



