package br.com.ioasys.camp.adaptoandroid.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.camp.adaptoandroid.extensions.viewState
import br.com.ioasys.camp.adaptoandroid.remote.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Headers

class LoginViewModel (
    private val repository: LoginRepository
    ) : ViewModel() {
        private val _headersLiveData by viewState<Headers>()
    val headersLiveData: LiveData<ViewState<Headers>> = _headersLiveData

    fun login(email: String, password: String) {
        _headersLiveData.value = ViewState.loading(true)
        viewModelScope.launch(Dispatchers.Main) {
            handleLogin(repository.login(email, password))
        }
    }

    private fun handleLogin(response: ResultWrapper<Headers>) {
        when(response) {
            is ResultWrapper.Success -> _headersLiveData.value = ViewState.success(response.data)
            is ResultWrapper.Failure -> _headersLiveData.value = ViewState.error(response.error)
        }
        _headersLiveData.value = ViewState.loading(false)
    }

    fun clearStatus() {
        _headersLiveData.value = null
    }
}
