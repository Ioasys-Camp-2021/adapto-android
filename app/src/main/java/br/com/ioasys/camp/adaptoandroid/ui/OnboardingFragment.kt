package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ioasys.camp.adaptoandroid.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    private lateinit var btnEntrar: Button
    private lateinit var btnCadastrar: Button
    private lateinit var btnPular: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnEntrar = binding.btnEntrar
        btnCadastrar = binding.btnCadastrar
        btnPular = binding.btnPular

        btnEntrar.setOnClickListener {
            findNavController().navigate(
                OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            )
        }

        btnCadastrar.setOnClickListener {
            findNavController().navigate(
                OnboardingFragmentDirections.actionOnboardingFragmentToRegisterFragment()
            )
        }

        btnPular.setOnClickListener {
//            findNavController().navigate(
//                OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
//            )
            Toast.makeText(requireContext(), "Navegando para a tela principal deslogado", LENGTH_LONG).show()
        }
    }
}