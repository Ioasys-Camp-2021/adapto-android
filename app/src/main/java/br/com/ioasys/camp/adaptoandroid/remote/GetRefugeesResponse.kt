package br.com.ioasys.camp.adaptoandroid.remote

import com.google.gson.annotations.SerializedName

data class GetRefugeesResponse (
    @SerializedName("refugees")
    val refugees: List<RefugeeResponse>,
)