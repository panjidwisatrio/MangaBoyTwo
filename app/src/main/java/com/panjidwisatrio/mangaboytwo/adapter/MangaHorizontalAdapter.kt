package com.panjidwisatrio.mangaboytwo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panjidwisatrio.mangaboytwo.databinding.ItemHorizontalMangaBinding
import com.panjidwisatrio.mangaboytwo.model.MangaPopular

class MangaHorizontalAdapter(private val listMangaHorizontal : ArrayList<MangaPopular>) : RecyclerView.Adapter<MangaHorizontalAdapter.MangaHorizontalAdapter>() {
    class MangaHorizontalAdapter(private var binding: ItemHorizontalMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(mangaHorizontal : MangaPopular) {
                with(binding) {
                    Glide.with(this.root)
                        .load(mangaHorizontal.img)
                        .into(imgHorizontal)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaHorizontalAdapter {
        val binding = ItemHorizontalMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaHorizontalAdapter(binding)
    }

    override fun onBindViewHolder(holder: MangaHorizontalAdapter, position: Int) {
        holder.bind(listMangaHorizontal[position])
    }

    override fun getItemCount(): Int {
        return listMangaHorizontal.size
    }
}