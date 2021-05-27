package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.adaptoandroid.R

class MainActivity : AppCompatActivity() {

//    private val btnRegisterLink: Button by lazy { findViewById(R.id.btnRegisterLink) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginFragment = LoginFragment()
        val registerFragment = RegisterFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flAuth, loginFragment)
            commit()
        }

//        btnRegisterLink.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.flAuth, registerFragment)
//                commit()
//            }
//        }

    }
}