package br.com.ioasys.camp.adaptoandroid.ui

import android.content.Intent
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
import br.com.ioasys.camp.adaptoandroid.presentation.*
import br.com.ioasys.camp.adaptoandroid.remote.LoginRequest
import br.com.ioasys.camp.adaptoandroid.remote.LoginResponse
import br.com.ioasys.camp.adaptoandroid.remote.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Headers

//@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var btnEntrar: Button
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnRegisterLink: Button
    private lateinit var loadingGroup: Group

//    @Inject
    private lateinit var viewModel: LoginViewModel

    private lateinit var service: UserService
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

        btnEntrar = binding.btnEntrar
        edtEmail = binding.edtEmail
        edtPassword = binding.edtPassword
        btnRegisterLink = binding.btnRegisterLink
        loadingGroup = binding.loadingGroup

//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        service = UserService.newInstance()
        manageLoadingGroup(show = false)

        btnRegisterLink.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            )
        }

        btnEntrar.setOnClickListener {
//            viewModel.login(edtEmail.text.toString(), edtPassword.text.toString())
            manageLoadingGroup(show = true)
            if(validateFields(edtEmail.text.toString(), edtPassword.text.toString())) {
                CoroutineScope(Dispatchers.Main).launch {
                    try {
                        Log.d("LoginFragment", "Trying to start request...")
                        val response = service.login(LoginRequest(
                                email = edtEmail.text.toString(),
                                password = edtPassword.text.toString()
                        ))
                        Log.d("LoginFragment", "Request done")

                        handleLogin(response)
                    } catch (e: Exception) {
                        Log.d("LoginFragment", "Error on login request: $e")
                        e.printStackTrace()
                        throw e
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Por favor preencha os campos de email e senha", LENGTH_LONG).show()
            }
            manageLoadingGroup(show = false)
        }
//        setObservers()
    }

    private fun validateFields(email: String, password: String): Boolean {
        return email != "" && password != ""
    }

    private fun manageLoadingGroup(show: Boolean) {
        loadingGroup.visibility = if (show) View.VISIBLE else View.GONE
//        Toast.makeText(requireContext(), "switching loading group visibility to $show", LENGTH_LONG).show()
    }

    private fun handleLogin(response: LoginResponse) {
        if(response.token != "") {
            val id = response.id
            val fullName = response.fullName
            val role = response.role
            val email = response.email
            val token = response.token
//            Log.d("LOGIN", "email: $email")
//            Log.d("LOGIN", "token: $token")

            val intent = Intent(requireContext(), HomeActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
                putExtra(EXTRA_FULLNAME, fullName)
                putExtra(EXTRA_ROLE, role)
                putExtra(EXTRA_EMAIL, email)
                putExtra(EXTRA_TOKEN, token)
            }
            startActivity(intent)
        } else {
            Log.d("LoginFragment", "login failed")
        }
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

