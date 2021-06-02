package br.com.ioasys.camp.adaptoandroid.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface UserService {

//    AUTHENTICATION
    @POST("auth/login/")
    suspend fun login(
            @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST("auth/login")
    suspend fun logout(
            @Header("Authorization") token: String
    ): Response<Unit>

//    CREATE USER
    @POST("user")
    suspend fun createUser(
        @Body createUserRequest: CreateUserRequest
    ): Response<Unit>


////    GET REFUGEE - IN PROGRESS
//    @GET("refugee/id")
//    suspend fun getRefugee(
//            @Header("access-token") accessToken: String,
//            @Header("client") client: String,
//            @Header("uid") uid: String
//    ): Response<GetRefugeesResponse>

    companion object {
        fun newInstance(): UserService = Retrofit.Builder()
                // UTILIZAR A URL DA API
                .baseUrl("https://adapto-api.herokuapp.com/api/")
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(UserService::class.java)

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build()
    }
}