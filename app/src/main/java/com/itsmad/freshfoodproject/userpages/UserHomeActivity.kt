package com.itsmad.freshfoodproject.userpages


import android.app.Activity
import android.content.Intent
import  android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.categories.FruttaVerduraActivity


class UserHomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var adapter: CategoriesAdapter
    private lateinit var bottomNavigation: BottomNavigationView

    private val cardList = mutableListOf<CategoriesClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        recyclerView = findViewById(R.id.categoriesRecyclerView)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        searchView = findViewById(R.id.search)
        prepareListCategoriesData()
        adapter = CategoriesAdapter(this,cardList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager=GridLayoutManager(this,2)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText ?: "")
                return true
            }
        })
        // Implementazione Bottom Navigation Bar
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Già nella Home, non fare nulla
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
                    val intent = Intent(this, UserCarrelloActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

    }

    private fun prepareListCategoriesData() {
        var categoriesCard = CategoriesClass("Frutta e verdura", R.drawable.ic_frutta_verdura)
        cardList.add(categoriesCard)
        categoriesCard = CategoriesClass("Banco frigo", R.drawable.ic_breve_scadenza)
        cardList.add(categoriesCard)
        categoriesCard = CategoriesClass("Prodotti da forno", R.drawable.ic_prodotti_da_forno)
        cardList.add(categoriesCard)
        categoriesCard = CategoriesClass("Prodotti Bio", R.drawable.ic_prodotti_bio)
        cardList.add(categoriesCard)
        categoriesCard = CategoriesClass("Prodotti per la casa", R.drawable.ic_casalinghi)
        cardList.add(categoriesCard)
        categoriesCard = CategoriesClass("Abbigliamento", R.drawable.ic_abbigliamento)
        cardList.add(categoriesCard)




    }
}

class CategoriesAdapter(private val getActivity: Activity, private var items: List<CategoriesClass>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var filteredItems: List<CategoriesClass> = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cards_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filteredItems[position])

        holder.cardView.setOnClickListener {
            // Verifica se la categoria cliccata è "Frutta e verdura"
            if (filteredItems[position].Name == "Frutta e verdura") {
                // Crea un intent per avviare FruttaVerduraActivity
                val intent = Intent(getActivity, FruttaVerduraActivity::class.java)
                getActivity.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = filteredItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val categoryName: TextView = itemView.findViewById(R.id.txtCategory)
         val categoryImage: ImageView = itemView.findViewById(R.id.imgCategory)
         val cardView : CardView = itemView.findViewById(R.id.cardView)

        fun bind(item: CategoriesClass) {
            categoryName.text = item.Name
            categoryImage.setImageResource(item.Image)
        }
    }

    fun filter(query: String) {
        filteredItems = if (query.isEmpty()) {
            items
        } else {
            items.filter { it.Name.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }
}