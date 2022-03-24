package com.panjidwisatrio.mangaboytwo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.panjidwisatrio.mangaboytwo.utils.MangaGridAdapter
import com.panjidwisatrio.mangaboytwo.utils.MangaHorizontalAdapter
import com.panjidwisatrio.mangaboytwo.utils.MangaSliderAdapter
import com.panjidwisatrio.mangaboytwo.data.dummy.MangaData
import com.panjidwisatrio.mangaboytwo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sliderAdapter : MangaSliderAdapter
    private lateinit var horizontalAdapter : MangaHorizontalAdapter
    private lateinit var gridAdapter : MangaGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showSliderList()
        showRecyclerCardView()
        showRecyclerHorizontalView()
    }

    private fun showRecyclerHorizontalView() {
        horizontalAdapter = MangaHorizontalAdapter(MangaData.listData) {
            //UBAH KODE NYA UNTUK EVENT SAAT IMAGE DI TAP
            Snackbar.make(
                binding.root,
                "Tapped ${it.title}", Snackbar.LENGTH_SHORT
            ).show()
        }

        with(binding.rvMangaHorizontal) {
            adapter = horizontalAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    private fun showRecyclerCardView() {
        gridAdapter = MangaGridAdapter(MangaData.listData) {
            //UBAH KODE NYA UNTUK EVENT SAAT IMAGE DI TAP
            Snackbar.make(
                binding.root,
                "Tapped ${it.title}", Snackbar.LENGTH_SHORT
            ).show()
        }

        with(binding.rvMangaGrid) {
            adapter = gridAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }

    private fun showSliderList() {
        sliderAdapter = MangaSliderAdapter(MangaData.listData) {
            //UBAH KODE NYA UNTUK EVENT SAAT IMAGE DI TAP
            Snackbar.make(
                binding.root,
                "Tapped ${it.title}", Snackbar.LENGTH_SHORT
            ).show()
        }

        with(binding.autoSlider) {
            startSliding(3000) // 3000 = 3 detik
            setImageListWithAdapter(sliderAdapter, MangaData.listData.size)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}