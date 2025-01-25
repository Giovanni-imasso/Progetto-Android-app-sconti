package com.itsmad.freshfoodproject.categories

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.itsmad.freshfoodproject.R

class RecycledViewCardsAdapter(private val getActivity: Activity, private val cardList:List<Categories>):
    RecyclerView.Adapter<RecycledViewCardsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cards_layout, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.categoriesName.text = cardList[position].name
        holder.categoriesImg.setImageResource(cardList[position].image)

        holder.cardView.setOnClickListener {
            // Verifica se la categoria cliccata è "Frutta e verdura"
            if (cardList[position].name == "Frutta e verdura") {
                // Crea un intent per avviare FruttaVerduraActivity
                val intent = Intent(getActivity, FruttaVerduraActivity::class.java)
                getActivity.startActivity(intent)
            }
        }
    }
    override fun getItemCount(): Int {
        return cardList.size
    }


    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val categoriesName: TextView = itemView.findViewById(R.id.txtCategory)
        val categoriesImg: ImageView = itemView.findViewById(R.id.imgCategory)
        val cardView : CardView = itemView.findViewById(R.id.cardView)





    }
}