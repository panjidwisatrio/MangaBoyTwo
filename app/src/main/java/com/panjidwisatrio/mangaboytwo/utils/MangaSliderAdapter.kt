package com.panjidwisatrio.mangaboytwo.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panjidwisatrio.mangaboytwo.data.Manga
import com.panjidwisatrio.mangaboytwo.databinding.ItemSliderMangaBinding

class MangaSliderAdapter(
    private var listManga : ArrayList<Manga>,
    val handler: (Manga) -> Unit
    ) :
    RecyclerView.Adapter<MangaSliderAdapter.MangaAdapter>() {

    class MangaAdapter(val binding : ItemSliderMangaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(Manga: Manga) {
            with(binding) {
                Glide.with(this.root)
                    .load(Manga.img)
                    .into(imgSlider)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaAdapter {
        val binding = ItemSliderMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaAdapter(binding)
    }

    override fun onBindViewHolder(holder: MangaAdapter, position: Int) = with(holder) {
        bind(listManga[position])
        binding.root.setOnClickListener { handler(listManga[position]) }
    }

    override fun getItemCount() = listManga.size
}