package com.example.characters.presentation.fragment.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.characters.common.CharactersStatus
import com.example.characters.data.model.Character
import com.example.characters.databinding.ItemCharacterCardBinding
import com.example.characters.presentation.utils.extension.convertToGrayscale
import com.example.characters.presentation.utils.extension.loadPhoto

class CharactersViewHolder(private val binding: ItemCharacterCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        binding.apply {
            if (character.status.uppercase() == CharactersStatus.DEAD.name) {
                binding.imageViewCharacterPhoto.convertToGrayscale()
            } else binding.imageViewCharacterPhoto.colorFilter = null
            binding.imageViewCharacterPhoto.loadPhoto(url = character.image, radius = 100)
            binding.customViewCharacterInfo.setData(character = character)
        }

    }


}
