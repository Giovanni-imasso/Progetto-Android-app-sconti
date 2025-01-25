package com.itsmad.freshfoodproject.userpages

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itsmad.freshfoodproject.FragmentCarrello
import com.itsmad.freshfoodproject.R

class UserCarrelloActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_carrello)

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
                    val intent = Intent(this, FidelityCardActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.navigation_cart -> {
                    
                    true
                }
                else -> false
            }
        }

        val confermaOrdineButton = findViewById<Button>(R.id.btn_conferma)

        val imageView: ImageView = findViewById(R.id.firstProduct)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.arance_bionde)
        val roundedDrawable = RoundedBitmapDrawableFactory.create(resources, bitmap)
        roundedDrawable.isCircular = true // Imposta se vuoi un'ellisse o un quadrato con angoli arrotondati
        roundedDrawable.cornerRadius = 16f // Raggio degli angoli
        imageView.setImageDrawable(roundedDrawable)

        val imageView2: ImageView = findViewById(R.id.secondProduct)
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.mozzarella)
        val roundedDrawable2 = RoundedBitmapDrawableFactory.create(resources, bitmap2)
        roundedDrawable2.isCircular = true // Imposta se vuoi un'ellisse o un quadrato con angoli arrotondati
        roundedDrawable2.cornerRadius = 16f // Raggio degli angoli
        imageView2.setImageDrawable(roundedDrawable2)

        val imageView3: ImageView = findViewById(R.id.thirdProduct)
        val bitmap3 = BitmapFactory.decodeResource(resources, R.drawable.melanzana)
        val roundedDrawable3 = RoundedBitmapDrawableFactory.create(resources, bitmap3)
        roundedDrawable3.isCircular = true // Imposta se vuoi un'ellisse o un quadrato con angoli arrotondati
        roundedDrawable3.cornerRadius = 16f // Raggio degli angoli
        imageView3.setImageDrawable(roundedDrawable3)

        confermaOrdineButton.setOnClickListener {
            // Crea e mostra il FragmentCarrello
            showConfirmationFragment()
        }
    }
    private fun showConfirmationFragment() {
        val fragmentCarrello = FragmentCarrello()

        supportFragmentManager.beginTransaction()
            .add(R.id.main, fragmentCarrello) // 'main' è l'id del ConstraintLayout root
            .commit()
    }
}