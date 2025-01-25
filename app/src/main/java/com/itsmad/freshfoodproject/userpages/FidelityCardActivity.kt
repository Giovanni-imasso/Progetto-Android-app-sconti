package com.itsmad.freshfoodproject.userpages

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itsmad.freshfoodproject.R

class FidelityCardActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fidelity_card)

        bottomNavigation = findViewById(R.id.bottom_navigation)

        // Implementazione Bottom Navigation Bar
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, UserHomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_orders -> {
                    val intent = Intent(this, UserOrdiniActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_fidelity -> {
                    // Già nella CARD, non fare nulla
                    true
                }

                R.id.navigation_cart -> {
                    val intent = Intent(this, UserCarrelloActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }
}