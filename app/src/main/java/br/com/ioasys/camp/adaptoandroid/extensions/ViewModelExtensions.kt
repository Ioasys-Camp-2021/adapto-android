package br.com.ioasys.camp.adaptoandroid.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.camp.adaptoandroid.presentation.ViewState

fun <T> ViewModel.viewState() = lazy {
    MutableLiveData<ViewState<T>>()
}