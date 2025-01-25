package com.itsmad.freshfoodproject.categories

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.userpages.FidelityCardActivity
import com.itsmad.freshfoodproject.userpages.UserHomeActivity
import com.itsmad.freshfoodproject.userpages.UserOrdiniActivity

class FruttaVerduraActivity : AppCompatActivity() {

    private var recyclerView :  RecyclerView? =null
    private var recycledViewCardsAdapter : RecycledViewCardsAdapter? = null
    private var cardListFruttaeVerdura = mutableListOf<Categories>()
    private lateinit var bottomNavigation: BottomNavigationView


    private val cardList2 = mutableListOf<Categories>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_frutta_verdura)
       cardListFruttaeVerdura = ArrayList()
        bottomNavigation = findViewById(R.id.bottom_navigation)

        recyclerView = findViewById(R.id.categoriesRecyclerView) as RecyclerView
        recycledViewCardsAdapter = RecycledViewCardsAdapter(this@FruttaVerduraActivity,cardListFruttaeVerdura)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!! .layoutManager = layoutManager
        recyclerView!! .adapter = recycledViewCardsAdapter

        prepareListCategoriesData()

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
    }

    private fun prepareListCategoriesData() {
        var categoriesCardFruttaEVerdura =  Categories("Arance bionde 2 Kg", R.drawable.arance_bionde)
       cardListFruttaeVerdura.add(categoriesCardFruttaEVerdura)
        categoriesCardFruttaEVerdura= Categories ("Kiwi(1 Kg)", R.drawable.kiwi)
        cardListFruttaeVerdura.add(categoriesCardFruttaEVerdura)
        categoriesCardFruttaEVerdura = Categories("Melanzane(1 kg)", R.drawable.melanzana)
        cardListFruttaeVerdura.add(categoriesCardFruttaEVerdura)
       categoriesCardFruttaEVerdura = Categories("Melone (1 kg)", R.drawable.melone)
        cardListFruttaeVerdura.add(categoriesCardFruttaEVerdura)
        categoriesCardFruttaEVerdura = Categories("Carote(1 kg)", R.drawable.carote)
        cardListFruttaeVerdura.add(categoriesCardFruttaEVerdura)
        categoriesCardFruttaEVerdura = Categories("Zucchini(1 kg) ", R.drawable.zucchini)
        cardListFruttaeVerdura.add(categoriesCardFruttaEVerdura)


        recycledViewCardsAdapter?.notifyDataSetChanged()
    }

}