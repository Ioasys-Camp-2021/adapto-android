package br.com.ioasys.camp.adaptoandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val btnLogin: Button by lazy {
        findViewById(R.id.btnLogin)
    }
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin.setOnClickListener {
            handleLogin(edtEmail.text.toString(), edtPassword.text.toString())
        }
    }

    private fun handleLogin(email: String, password: String) {
//        INSERT NAVIGATION TO NEXT ACTIVITY
        Toast.makeText(this, "Button pressed with email ${email} and password ${password}", LENGTH_LONG).show()
    }
}