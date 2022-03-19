package com.panjidwisatrio.mangaboytwo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.panjidwisatrio.mangaboytwo.databinding.ItemSliderMangaBinding
import com.panjidwisatrio.mangaboytwo.model.MangaSlider

class MangaSliderAdapter(private val listMangaSlider : ArrayList<MangaSlider>, private val viewPager : ViewPager2) :
    RecyclerView.Adapter<MangaSliderAdapter.MangaAdapter>() {

    class MangaAdapter(private var binding : ItemSliderMangaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mangaSlider: MangaSlider) {
            with(binding) {
                Glide.with(this.root)
                    .load(mangaSlider.img)
                    .into(imgSlider)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaAdapter {
        val binding = ItemSliderMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaAdapter(binding)
    }

    override fun onBindViewHolder(holder: MangaAdapter, position: Int) {
        holder.bind(listMangaSlider[position])
        if (position == listMangaSlider.size - 2) {
            viewPager.post(run)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    val run = Runnable {
        listMangaSlider.addAll(listMangaSlider)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listMangaSlider.size
    }
}