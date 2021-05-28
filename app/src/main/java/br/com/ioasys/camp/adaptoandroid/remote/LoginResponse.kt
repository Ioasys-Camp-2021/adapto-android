package br.com.ioasys.camp.adaptoandroid.remote

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("email")
    val email: String,

    @SerializedName("token")
    val token: String
)