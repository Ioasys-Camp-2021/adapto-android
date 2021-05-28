package br.com.ioasys.camp.adaptoandroid.presentation

import br.com.ioasys.camp.adaptoandroid.remote.UserService

class LoginRepository(
        private val service: UserService
) {

//    suspend fun login(email: String, password: String) : ResultWrapper<Headers> {
//        val response = service.login(
//                LoginRequest(
//                        email = email,
//                        password = password
//                )
//        )
//        return if(response.token != "") {
//            ResultWrapper.Success(response)
//        } else {
//            ResultWrapper.Failure(Throwable("Algo inesperado ocorreu!"))
//        }
//    }
}