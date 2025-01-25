package com.itsmad.freshfoodproject.accesso  // Dichiarazione del package dell'app

import android.content.Intent  // Import per gestire l'avvio della nuova activity
import android.os.Bundle  // Import per gestire il ciclo di vita dell'activity
import android.text.Editable  // Import per l'editing del testo
import android.text.TextWatcher  // Import per monitorare i cambiamenti di testo
import androidx.appcompat.app.AppCompatActivity  // Import per utilizzare le funzionalità delle activity
import android.widget.EditText  // Import per il widget EditText
import android.widget.Button  // Import per il widget Button
import com.google.android.material.snackbar.Snackbar  // Import per utilizzare la Snackbar
import androidx.constraintlayout.widget.ConstraintLayout  // Import per il ConstraintLayout
import com.itsmad.freshfoodproject.R  // Import per le risorse dell'app
import com.itsmad.freshfoodproject.preview.Preview1Activity

class OtpVerificationCodePage : AppCompatActivity() {  // Classe principale dell'activity

    // Codice OTP predefinito
    private val predefinedOtpCode = "1234"  // Codice OTP che l'utente deve inserire

    override fun onCreate(savedInstanceState: Bundle?) {  // Metodo chiamato alla creazione dell'activity
        super.onCreate(savedInstanceState)  // Chiamata al costruttore della superclasse
        setContentView(R.layout.activity_otp_verification_code_page)  // Imposta il layout dell'activity

        val rootLayout = findViewById<ConstraintLayout>(R.id.rootLayout)  // Trova il layout radice per la Snackbar

        // Collega i campi di input per il codice OTP
        val otpDigit1 = findViewById<EditText>(R.id.otp_digit_1)  // Primo campo OTP
        val otpDigit2 = findViewById<EditText>(R.id.otp_digit_2)  // Secondo campo OTP
        val otpDigit3 = findViewById<EditText>(R.id.otp_digit_3)  // Terzo campo OTP
        val otpDigit4 = findViewById<EditText>(R.id.otp_digit_4)  // Quarto campo OTP

        // Bottone per inviare il codice OTP
        val buttonInvia = findViewById<Button>(R.id.button_invia)  // Bottone per inviare il codice OTP
        val buttonResend = findViewById<Button>(R.id.button_resend)  // Bottone per reinviare il codice

        buttonInvia.setOnClickListener {  // Imposta il listener per il click sul bottone di invio
            // Unisce il testo di tutti i campi OTP in un'unica stringa
            val otpCode = otpDigit1.text.toString() + otpDigit2.text.toString() +
                    otpDigit3.text.toString() + otpDigit4.text.toString()

            // Verifica se tutti i campi sono stati riempiti
            if (otpCode.length == 4) {  // Se il codice inserito ha esattamente 4 caratteri
                // Controlla se il codice inserito corrisponde al codice predefinito
                if (otpCode == predefinedOtpCode) {  // Se il codice è corretto
                    // Se il codice è corretto, avvia una nuova activity
                    val intent = Intent(this, Preview1Activity::class.java)  // Crea un'intenzione per avviare la nuova activity
                    startActivity(intent)  // Avvia la nuova activity
                } else {  // Se il codice è errato
                    // Se il codice è errato, mostra l'errore "Codice errato" dal file strings.xml
                    val invalidCodeMessage = getString(R.string.error_invalid_code)  // Ottiene il messaggio di errore
                    Snackbar.make(rootLayout, invalidCodeMessage, Snackbar.LENGTH_LONG).show()  // Mostra la Snackbar con l'errore
                }
            } else {  // Se non tutte le cifre sono state inserite
                // Mostra un errore se non tutte le cifre sono state inserite
                val errorMessage = getString(R.string.error_snackbar)  // Ottiene il messaggio di errore per input parziale
                Snackbar.make(rootLayout, errorMessage, Snackbar.LENGTH_LONG).show()  // Mostra la Snackbar con l'errore
            }
        }

        // Gestione del click su "Invia nuovo codice"
        buttonResend.setOnClickListener {  // Imposta il listener per il click sul bottone di reinvio
            // Mostra una Snackbar con il messaggio di codice reinviato
            val resendMessage = getString(R.string.code_resent_success)  // Ottiene il messaggio di successo dal file strings.xml
            Snackbar.make(rootLayout, resendMessage, Snackbar.LENGTH_LONG).show()  // Mostra la Snackbar con il messaggio di successo
        }
    }
}