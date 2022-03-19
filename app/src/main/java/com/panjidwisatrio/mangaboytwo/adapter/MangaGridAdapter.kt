package com.panjidwisatrio.mangaboytwo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panjidwisatrio.mangaboytwo.databinding.ItemGridMangaBinding
import com.panjidwisatrio.mangaboytwo.model.MangaTerbaru

class MangaGridAdapter(private val listMangaGrid : ArrayList<MangaTerbaru>) : RecyclerView.Adapter<MangaGridAdapter.MangaGridAdapter>() {
    class MangaGridAdapter(private var binding: ItemGridMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(mangaTerbaru: MangaTerbaru) {
                with(binding) {
                    Glide.with(this.root)
                        .load(mangaTerbaru.img)
                        .into(imgGrid)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaGridAdapter {
        val binding = ItemGridMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaGridAdapter(binding)
    }

    override fun onBindViewHolder(holder: MangaGridAdapter, position: Int) {
        holder.bind(listMangaGrid[position])
    }

    override fun getItemCount(): Int {
        return listMangaGrid.size
    }
}