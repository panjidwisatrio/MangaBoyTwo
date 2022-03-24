package com.panjidwisatrio.mangaboytwo.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panjidwisatrio.mangaboytwo.data.Manga
import com.panjidwisatrio.mangaboytwo.databinding.ItemHorizontalMangaBinding

class MangaHorizontalAdapter(
    private val listMangaHorizontal : ArrayList<Manga>,
    val handler: (Manga) -> Unit
) : RecyclerView.Adapter<MangaHorizontalAdapter.MangaHorizontalAdapter>() {
    class MangaHorizontalAdapter(val binding: ItemHorizontalMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(mangaHorizontal : Manga) = with(binding) {
                Glide.with(this.root)
                    .load(mangaHorizontal.img)
                    .into(imgHorizontal)

                tvHorizontal.text = mangaHorizontal.title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MangaHorizontalAdapter (
        ItemHorizontalMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MangaHorizontalAdapter, position: Int) = with(holder) {
        bind(listMangaHorizontal[position])
        binding.root.setOnClickListener { handler(listMangaHorizontal[position]) }
    }

    override fun getItemCount() = listMangaHorizontal.size

}