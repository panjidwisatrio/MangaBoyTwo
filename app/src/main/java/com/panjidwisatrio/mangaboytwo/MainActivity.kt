package com.panjidwisatrio.mangaboytwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.panjidwisatrio.mangaboytwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val navController = findNavController(R.id.nav_host_fragment)

        AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.scheduleFragment,
                R.id.genreFragment,
                R.id.favoriteFragment,
                R.id.aboutFragment
            )
        )

        with(binding.navbar) {
            itemIconTintList = null
            setupWithNavController(navController)
        }
    }
}