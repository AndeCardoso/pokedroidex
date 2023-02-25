package com.ande.pokedroidex.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ande.pokedroidex.R
import com.ande.pokedroidex.domain.Pokemon
import com.ande.pokedroidex.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokeList)

        val bulbasaur = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png",
            1,
            "Bulbasaour",
            listOf(
                PokemonType("Grama"),
                PokemonType("Veneno")
            )
        )
        val pokemons = listOf(
            bulbasaur, bulbasaur, bulbasaur, bulbasaur, bulbasaur, bulbasaur, bulbasaur, bulbasaur
        )

        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = PokeAdapter(pokemons)
    }
}