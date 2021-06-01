package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.ioasys.camp.adaptoandroid.databinding.FragmentLoggedHomeBinding

class LoggedHomeFragment : Fragment() {

    private var _binding: FragmentLoggedHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var tvHomeEmail: TextView
    private lateinit var tvHomeToken: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoggedHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val email = intent.getStringExtra(EXTRA_EMAIL)
//        tvHomeEmail.text = email
//        Log.d("HomeActivity", "Email: $email")
//
//        val token = intent.getStringExtra(EXTRA_TOKEN)
//        tvHomeToken.text = token
//        Log.d("HomeActivity", "Token: $token")
    }
}