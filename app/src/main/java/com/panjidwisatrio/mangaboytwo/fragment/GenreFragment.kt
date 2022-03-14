package com.panjidwisatrio.mangaboytwo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panjidwisatrio.mangaboytwo.databinding.FragmentGenreBinding

class GenreFragment : Fragment() {

    private lateinit var binding: FragmentGenreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGenreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}