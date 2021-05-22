package br.com.ioasys.camp.adaptoandroid.presentation

import br.com.ioasys.camp.adaptoandroid.remote.LoginRequest
import br.com.ioasys.camp.adaptoandroid.remote.ResultWrapper
import br.com.ioasys.camp.adaptoandroid.remote.UserService
import okhttp3.Headers

class LoginRepository(
        private val service: UserService
) {

    suspend fun login(email: String, password: String) : ResultWrapper<Headers> {
        val response = service.login(
                LoginRequest(
                        email = email,
                        password = password
                )
        )
        return if(response.isSuccessful) {
            ResultWrapper.Success(response.headers())
        } else {
            ResultWrapper.Failure(Throwable("Algo inesperado ocorreu!"))
        }
    }
}