package com.panjidwisatrio.mangaboytwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.panjidwisatrio.mangaboytwo.databinding.ActivityMainBinding
import com.panjidwisatrio.mangaboytwo.fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val HomeFragment = HomeFragment()
    private val ScheduleFragment = ScheduleFragment()
    private val GenreFragment = GenreFragment()
    private val FavoriteFragment = FavoriteFragment()
    private val AboutFragment = AboutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navbar.itemIconTintList = null
        currentPage(HomeFragment)
        supportActionBar?.hide()

        binding.navbar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_home -> {
                    currentPage(HomeFragment)
                }
                R.id.page_schedule -> {
                    currentPage(ScheduleFragment)
                }
                R.id.page_genre -> {
                    currentPage(GenreFragment)
                }
                R.id.page_favorite -> {
                    currentPage(FavoriteFragment)
                }
                R.id.page_about -> {
                    currentPage(AboutFragment)
                }
            }
            true
        }
    }

    private fun currentPage(fragment : Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.container, fragment)
        commit()
    }
}