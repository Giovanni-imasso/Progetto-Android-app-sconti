package com.itsmad.freshfoodproject.userpages

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.itsmad.freshfoodproject.R
import com.itsmad.freshfoodproject.categories.FruttaVerduraActivity

class AdapterClass(private val getActivity: Activity, private val categoriesList: ArrayList<CategoriesClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterClass.ViewHolderClass {
        val categoriesView =
            LayoutInflater.from(parent.context).inflate(R.layout.cards_layout, parent, false)
        return ViewHolderClass(categoriesView)
    }

    override fun onBindViewHolder(holder: AdapterClass.ViewHolderClass, position: Int) {
        val currentItem = categoriesList[position]
        holder.categoriesImage.setImageResource(currentItem.Image)
        holder.categoriestxt.text = currentItem.Name
        holder.cardView.setOnClickListener {
            // Verifica se la categoria cliccata è "Frutta e verdura"
            if (categoriesList[position].Name == "Frutta e verdura") {
                // Crea un intent per avviare FruttaVerduraActivity
                val intent = Intent(getActivity, FruttaVerduraActivity::class.java)
                getActivity.startActivity(intent)
            }
        }

    }


    override fun getItemCount(): Int {
        return categoriesList.size
    }

    class ViewHolderClass(categoriesView: View): RecyclerView. ViewHolder(categoriesView) {
        val categoriesImage:ImageView = categoriesView.findViewById(R.id.imgCategory)
        val categoriestxt:TextView = categoriesView.findViewById(R.id.txtCategory)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}