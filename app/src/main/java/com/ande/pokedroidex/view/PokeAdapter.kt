package com.ande.pokedroidex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ande.pokedroidex.R
import com.ande.pokedroidex.domain.Pokemon

class PokeAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poke_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView) {
            val ivPokeImage = findViewById<ImageView>(R.id.ivPokeImage)
            val tvPokeNumber = findViewById<TextView>(R.id.tvPokeNumber)
            val tvPokeName = findViewById<TextView>(R.id.tvPokeName)
            val tvPokeType1 = findViewById<TextView>(R.id.tvPokeType1)
            val tvPokeType2 = findViewById<TextView>(R.id.tvPokeType2)

            //TODO: Load image with lib

            tvPokeNumber.text = "Nº ${item.formattedNumber}"
            tvPokeName.text = item.name
            tvPokeType1.text = item.types[0].name

            if (item.types.size > 1) {
                tvPokeType2.visibility = View.VISIBLE
                tvPokeType2.text = item.types[1].name
            } else {
                tvPokeType2.visibility = View.GONE
            }

        }
    }

}