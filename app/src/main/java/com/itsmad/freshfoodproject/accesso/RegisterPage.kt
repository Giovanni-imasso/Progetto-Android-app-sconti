package com.itsmad.freshfoodproject.accesso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.databinding.ActivityRegisterPageBinding

class RegisterPage : AppCompatActivity() {
    lateinit var signUpBinding: ActivityRegisterPageBinding
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivityRegisterPageBinding.inflate(layoutInflater)

        val view =signUpBinding.root
        setContentView(view)

        signUpBinding.BtnRegister.setOnClickListener {
            val userEmail =signUpBinding.EditEmail.text.toString()
            val userPassword =signUpBinding.EditPassword.text.toString()
            signupWithFirebase(userEmail, userPassword)
        }

    }

    fun signupWithFirebase(userEmail : String, userPassword: String) {
        auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(applicationContext,"Account creato", Toast.LENGTH_SHORT).show()
                finish()
            }else {
                Toast.makeText(applicationContext,task.exception?.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }
}