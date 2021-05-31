package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import br.com.ioasys.camp.adaptoandroid.databinding.FragmentRegisterBinding
import br.com.ioasys.camp.adaptoandroid.remote.CreateUserRequest
import br.com.ioasys.camp.adaptoandroid.remote.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var edtFirstName: EditText
    private lateinit var edtLastName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var loadingGroup: Group

    private lateinit var service: UserService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtFirstName = binding.edtFirstName
        edtLastName = binding.edtLastName
        edtEmail = binding.edtEmail
        edtPassword = binding.edtPassword
        btnRegister = binding.btnRegister
        loadingGroup = binding.loadingGroup

        service = UserService.newInstance()

        btnRegister.setOnClickListener {
            manageLoadingGroup(true)
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    Log.d("RegisterFragment", "Trying to start request...")
                    val response = service.createUser(
                        CreateUserRequest(
                            firstName = edtFirstName.text.toString(),
                            lastName = edtLastName.text.toString(),
                            email = edtEmail.text.toString(),
                            password = edtPassword.text.toString()
                        )
                    )
                    Log.d("RegisterFragment", "Request done")

                    handleRegister(response)
                } catch (e: Exception) {
                    Log.d("RegisterFragment", "Error on register request: $e")
                    e.printStackTrace()
                    throw e
                }
            }
            manageLoadingGroup(false)
        }

    }

    private fun manageLoadingGroup(show: Boolean) {
        if(show)
            this.loadingGroup.visibility = View.VISIBLE
        else
            this.loadingGroup.visibility = View.GONE
    }

    private fun handleRegister(response: Response<Unit>) {
        if(response.isSuccessful) {
            Log.d("REGISTER", "response: ${response.body()}")
        }
    }
}