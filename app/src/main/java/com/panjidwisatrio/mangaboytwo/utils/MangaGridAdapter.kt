package com.panjidwisatrio.mangaboytwo.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panjidwisatrio.mangaboytwo.data.Manga
import com.panjidwisatrio.mangaboytwo.databinding.ItemGridMangaBinding

class MangaGridAdapter(
    private val listMangaGrid : ArrayList<Manga>,
    val handler : (Manga) -> Unit
) : RecyclerView.Adapter<MangaGridAdapter.MangaGridAdapter>() {
    class MangaGridAdapter(val binding: ItemGridMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(Manga: Manga) = with(binding) {
                Glide.with(this.root)
                    .load(Manga.img)
                    .into(imgGrid)

                tvGrid.text = Manga.title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MangaGridAdapter (
        ItemGridMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MangaGridAdapter, position: Int) = with(holder) {
        bind(listMangaGrid[position])
        binding.root.setOnClickListener { handler(listMangaGrid[position]) }
    }

    override fun getItemCount() = listMangaGrid.size
}