package com.example.pokemoncatia.view.flash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemoncatia.MainActivity
import com.example.pokemoncatia.R
import com.example.pokemoncatia.repository.PokemonRepository
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.Observer


class FlashActivity : AppCompatActivity() {

    val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)

        splashViewModel.checkHealth()

        splashViewModel.messageError.observe(this, androidx.lifecycle.Observer {
            if (it == "") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }
    }


