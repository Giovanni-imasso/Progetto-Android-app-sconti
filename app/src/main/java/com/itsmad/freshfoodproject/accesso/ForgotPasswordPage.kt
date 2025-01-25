package com.itsmad.freshfoodproject.accesso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.databinding.ActivityForgotPasswordPageBinding


class ForgotPasswordPage : AppCompatActivity() {

    lateinit var forgetBinding: ActivityForgotPasswordPageBinding

    val auth: FirebaseAuth =FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forgetBinding = ActivityForgotPasswordPageBinding.inflate(layoutInflater)
        val view = forgetBinding.root
        setContentView(view)

        forgetBinding.buttonSend.setOnClickListener {

            val email = forgetBinding.EditEmail.text.toString()

            auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext,"Password reset spedito alla tua email",Toast.LENGTH_SHORT).show()
                    finish()


            }
        }
    }



    }
}