package com.itsmad.freshfoodproject.accesso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.databinding.ActivityLoginPageBinding
import com.itsmad.freshfoodproject.preview.Preview1Activity


class LoginPage : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginPageBinding

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login_page)

        val view = loginBinding.root
        setContentView(view)

        loginBinding.BtnLogin.setOnClickListener {
            val userEmail =loginBinding.EditEmail.text.toString()
            val userPassword =loginBinding.EditPassword.text.toString()

            signinWithFirebase(userEmail, userPassword)

        }
        loginBinding.ForgotPsw.setOnClickListener {
            val intent = Intent(this,ForgotPasswordPage::class.java)
            startActivity(intent)
        }
    }
    fun signinWithFirebase(userEmail: String, userPassword: String) {

        auth.signInWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    Toast.makeText(applicationContext,"accesso effettuato correttamente", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginPage,Preview1Activity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(applicationContext,"Dati non validi", Toast.LENGTH_SHORT).show()
                }
            }
    }
}



