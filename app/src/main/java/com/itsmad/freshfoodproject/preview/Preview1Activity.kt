package com.itsmad.freshfoodproject.preview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.userpages.UserHomeActivity

class Preview1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview1)
        // Inizializza i pulsanti
        val buttonSkip: Button = findViewById(R.id.buttonSkip)
        val buttonStart: Button = findViewById(R.id.buttonStart)

        // Listener per il pulsante "Salta"
        buttonSkip.setOnClickListener {
            val intent = Intent(this, UserHomeActivity::class.java) // Cambia con l'activity di destinazione
            startActivity(intent)  // Avvia l'activity di destinazione
        }

        // Listener per il pulsante "Iniziamo"
        buttonStart.setOnClickListener {
            val intent = Intent(this, Preview2Activity::class.java) // Cambia con l'activity di destinazione
            startActivity(intent)  // Avvia l'activity di destinazione
        }
    }
}