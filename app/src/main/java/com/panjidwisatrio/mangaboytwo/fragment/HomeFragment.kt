package com.panjidwisatrio.mangaboytwo.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.panjidwisatrio.mangaboytwo.adapter.MangaGridAdapter
import com.panjidwisatrio.mangaboytwo.adapter.MangaHorizontalAdapter
import com.panjidwisatrio.mangaboytwo.adapter.MangaSliderAdapter
import com.panjidwisatrio.mangaboytwo.data.MangaData
import com.panjidwisatrio.mangaboytwo.databinding.FragmentHomeBinding
import com.panjidwisatrio.mangaboytwo.model.MangaPopular
import com.panjidwisatrio.mangaboytwo.model.MangaSlider
import com.panjidwisatrio.mangaboytwo.model.MangaTerbaru

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRunnable : Runnable
    private var listSlider : ArrayList<MangaSlider> = arrayListOf()
    private var listPopular : ArrayList<MangaPopular> = arrayListOf()
    private var listTerbaru : ArrayList<MangaTerbaru> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.rvManga.setHasFixedSize(true)
        listSlider.addAll(MangaData.listDataSlider)
        listPopular.addAll(MangaData.listDataHorizontal)
        listTerbaru.addAll(MangaData.listDataGrid)
        showViewPagerList()
        showRecyclerCardView()
        showRecyclerHorizontalView()
    }

    private fun showRecyclerHorizontalView() {
        val rvHorizontal = binding.rvMangaHorizontal

        rvHorizontal.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val mangaHorizontalAdapter = MangaHorizontalAdapter(listPopular)
        rvHorizontal.adapter = mangaHorizontalAdapter
    }

    private fun showRecyclerCardView() {
        val rvGrid = binding.rvMangaGrid

        rvGrid.layoutManager = GridLayoutManager(activity, 3)
        val mangaGridAdapter = MangaGridAdapter(listTerbaru)
        rvGrid.adapter = mangaGridAdapter
    }

    private fun showViewPagerList() {
        val viewPager2 = binding.sliderIv
        val listMangaAdapter = MangaSliderAdapter(listSlider, viewPager2)

        with(viewPager2) {
            adapter = listMangaAdapter
            offscreenPageLimit = listSlider.size
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        sliderHandler = Handler()
        sliderRunnable = Runnable {
            viewPager2.currentItem = viewPager2.currentItem + 1
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }

}