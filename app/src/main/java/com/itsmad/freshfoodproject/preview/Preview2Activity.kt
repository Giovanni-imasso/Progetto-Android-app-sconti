package com.itsmad.freshfoodproject.preview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.userpages.UserHomeActivity

class Preview2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview2)

        // Listener per il layout principale
        val mainLayout = findViewById<View>(R.id.main)
        mainLayout.setOnClickListener {
            // Naviga alla schermata preview3
            val intent = Intent(this, Preview3Activity::class.java)
            startActivity(intent)
        }

        // Listener per il pulsante "Salta"
        val buttonSkip = findViewById<View>(R.id.buttonSkip)
        buttonSkip.setOnClickListener {
            // Naviga all'activity UserHomeActivity
            val intent = Intent(this, UserHomeActivity::class.java)
            startActivity(intent)
        }
    }
}