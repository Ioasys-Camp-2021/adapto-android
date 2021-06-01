package br.com.ioasys.camp.adaptoandroid.remote

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("id")
    val id: Int,

    @SerializedName("fullName")
    val fullName: String,

    @SerializedName("role")
    val role: Int,

    @SerializedName("email")
    val email: String,

    @SerializedName("token")
    val token: String
)