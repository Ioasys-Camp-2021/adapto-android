package br.com.ioasys.camp.adaptoandroid.remote

import com.google.gson.annotations.SerializedName

data class CreateUserRequest (
    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,
)