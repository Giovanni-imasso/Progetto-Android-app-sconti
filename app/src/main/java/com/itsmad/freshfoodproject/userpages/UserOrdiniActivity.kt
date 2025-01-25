package com.itsmad.freshfoodproject.userpages

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itsmad.freshfoodproject.R

class UserOrdiniActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_ordini)

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

                    true
                }
                R.id.navigation_fidelity -> {
                    val intent = Intent(this, FidelityCardActivity::class.java)
                    startActivity(intent)
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


        val listView: ListView = findViewById(R.id.listView)
        val listItems = arrayOf(
            "Ordine 508299 del 27/11/2024",
            "Ordine 508266 del 25/11/2024",
            "Ordine 508255 del 21/11/2024",
            "Ordine 508244 del 18/11/2024",
            "Ordine 508236 del 15/11/2024",
            "Ordine 508200 del 12/11/2024",
            "Ordine 508100 del 03/11/2024",
            "Ordine 508010 del 29/10/2024",
            "Ordine 507036 del 24/10/2024",
            "Ordine 507005 del 21/10/2024",
            "Ordine 507002 del 20/10/2024",
            "Ordine 506214 del 01/10/2024",
            "Ordine 505136 del 21/09/2024",
            "Ordine 503315 del 24/07/2024",
            "Ordine 501236 del 23/06/2024")
        val listAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listItems)
        listView.adapter = listAdapter






    }
}