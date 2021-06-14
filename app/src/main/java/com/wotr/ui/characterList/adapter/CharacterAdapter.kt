package com.wotr.ui.characterList.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wotr.R
import com.wotr.domain.dto.CharacterDto

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    var characters: List<CharacterDto> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = CharacterItemBindf.bind(itemView)

        fun bind(book: CharacterDto) {
            binding.tvTitle.text = book.title
            binding.tvAuthor.text = book.author
            binding.tvSummary.text = book.description
            binding.tvRank.text = book.rank.toString()

            val context = binding.root.context

            if (book.weeksOnList != 1) {
                binding.tvWeeksOnList.text = context.getString(R.string.labelWeeksOnList, book.weeksOnList)
                binding.tvWeeksOnList.setTextColor(Color.GRAY)
            } else {
                binding.tvWeeksOnList.setText(R.string.labelNewOnList)
                binding.tvWeeksOnList.setTextColor(context.getColor(R.color.green_600))
            }

            Glide.with(itemView.context)
                .load(book.image)
                .into(binding.ivCover)
        }

    }

}