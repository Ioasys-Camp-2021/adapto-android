package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.camp.adaptoandroid.databinding.FragmentLoginBinding
import br.com.ioasys.camp.adaptoandroid.presentation.LoginViewModel
import br.com.ioasys.camp.adaptoandroid.presentation.ViewState
import okhttp3.Headers

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var btnLogin: Button
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnRegisterLink: Button
    private lateinit var viewLoading: View
    private lateinit var loadingGroup: Group

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin = binding.btnLogin
        edtEmail = binding.edtEmail
        edtPassword = binding.edtPassword
        btnRegisterLink = binding.btnRegisterLink
        viewLoading = binding.viewLoading
        loadingGroup = binding.loadingGroup

//        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(Application())).get(LoginViewModel::class.java)

        btnRegisterLink.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            )
            Toast.makeText(requireContext(), "TESTE AQUI", LENGTH_LONG).show()
        }

//        btnLogin.setOnClickListener {
//            viewModel.login(edtEmail.text.toString(), edtPassword.text.toString())
//        }
//        setObservers()
    }

    private fun setObservers() {
        viewModel.headersLiveData.observe(viewLifecycleOwner, {
            when(it.state) {
                ViewState.State.SUCESS -> onResultSuccess(it.data)
                ViewState.State.ERROR -> onResultError(it.error)
                ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })
    }

    private fun onLoading(loading: Boolean) {
        Log.d("LoginFragment", "OnLoading -> $loading")
    }

    private fun onResultError(error: Throwable?) {
        Log.d("LoginFragment", "OnResultError -> $error")
    }

    private fun onResultSuccess(data: Headers?) {
        Toast.makeText(requireContext(), "User logged, server response with status 200 - OK -> $data", LENGTH_LONG).show()
    }
}

