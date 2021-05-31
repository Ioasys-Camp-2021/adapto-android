package br.com.ioasys.camp.adaptoandroid.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.adaptoandroid.R

class HomeActivity : AppCompatActivity() {

    private val tvHomeEmail: TextView by lazy { findViewById(R.id.tvHomeEmail) }
    private val tvHomeToken: TextView by lazy { findViewById(R.id.tvHomeToken) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tvHomeEmail.text = intent.getStringExtra(EXTRA_EMAIL)
        tvHomeToken.text = intent.getStringExtra(EXTRA_TOKEN)
    }
}