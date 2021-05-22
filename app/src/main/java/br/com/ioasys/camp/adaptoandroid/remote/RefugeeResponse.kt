package br.com.ioasys.camp.adaptoandroid.remote

import com.google.gson.annotations.SerializedName

data class RefugeeResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("refugee_name")
    val refugeeName: String
)