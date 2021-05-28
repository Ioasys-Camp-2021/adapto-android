package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.adaptoandroid.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginFragment = LoginFragment()
        val registerFragment = RegisterFragment()
        val splashScreenFragment = SplashScreenFragment()

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.flAuth, splashScreenFragment)
//            commit()
//        }
    }
}