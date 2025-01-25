package com.itsmad.freshfoodproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.itsmad.freshfoodproject.accesso.LoginPage
import com.itsmad.freshfoodproject.accesso.RegisterPage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Pulsante Registrati
        val registerButton: Button = findViewById(R.id.btn_register)
        registerButton.setOnClickListener {
            // Intent per andare alla RegisterPage
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }

        // Pulsante Login
        val loginButton: Button = findViewById(R.id.login)
        loginButton.setOnClickListener {
            // Intent per andare alla LoginPage
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
}