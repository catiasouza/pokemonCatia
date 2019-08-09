package com.example.pokemoncatia.view.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemoncatia.R
import com.example.pokemoncatia.view.form.FormActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.include_loading.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListActivity : AppCompatActivity() {

    val listPokemonViewModel: ListPokemonsViewModel by viewModel()
    val picasso: Picasso by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listPokemonViewModel.getPokemons()

        listPokemonViewModel.isLoading.observe(this, Observer {
            if(it == true) {
                containerLoading.visibility = View.VISIBLE
            } else {
                containerLoading.visibility = View.GONE
            }

        })

        listPokemonViewModel.messageError.observe(this, Observer {
            if(it != "") {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

        listPokemonViewModel.pokemons.observe(this, Observer {
            rvPokemons.adapter = ListPokemonsAdapter(it, picasso) {
                val intent = Intent(this, FormActivity::class.java)
                intent.putExtra("POKEMON", it)
                startActivity(intent)
                finish()
            }
            rvPokemons.layoutManager = GridLayoutManager(this, 3)
        })

    }
}


