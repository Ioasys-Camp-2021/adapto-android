package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.adaptoandroid.R

class MainActivity : AppCompatActivity() {
    private val btnLogin: Button by lazy { findViewById(R.id.btnLogin) }
    private val edtEmail: EditText by lazy { findViewById(R.id.edtEmail) }
    private val edtPassword: EditText by lazy { findViewById(R.id.edtPassword) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            handleLogin(edtEmail.text.toString(), edtPassword.text.toString())
        }
    }

    private fun handleLogin(email: String, password: String) {
//        INSERT NAVIGATION TO NEXT ACTIVITY
        Toast.makeText(this, "Button pressed with email '$email' and password '$password'.", LENGTH_LONG).show()
    }
}