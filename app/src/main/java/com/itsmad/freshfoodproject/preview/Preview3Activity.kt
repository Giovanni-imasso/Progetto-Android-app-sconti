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

class Preview3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview3)
// Riferimento al pulsante "Fine"
        val buttonEnd = findViewById<Button>(R.id.buttonEnd)

        // Listener per il pulsante "Fine"
        buttonEnd.setOnClickListener {
            // Naviga all'activity UserHomeActivity
            val intent = Intent(this, UserHomeActivity::class.java)
            startActivity(intent)
        }
    }
}