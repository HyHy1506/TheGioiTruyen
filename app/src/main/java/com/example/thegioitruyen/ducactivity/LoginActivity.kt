package com.example.thegioitruyen.ducactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thegioitruyen.R
import com.example.thegioitruyen.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var bindinng: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindinng= ActivityLoginBinding.inflate(layoutInflater)
        val view=bindinng.root
        enableEdgeToEdge()
        setContentView(view)


        bindinng.btnSignUpLogin.setOnClickListener{
            var intent= Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }




    }
}