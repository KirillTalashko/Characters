package com.example.characters.presentation.fragment.viewHolder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.characters.common.CharactersStatus
import com.example.characters.data.model.Character
import com.example.characters.databinding.ItemCharacterCardBinding
import com.example.characters.presentation.utils.extension.loadPhoto

class CharactersViewHolder(private val binding: ItemCharacterCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        binding.apply {
            Log.i(
                "youTag",
                "${CharactersStatus.valueOf(character.status.uppercase())}, ${character.id}"
            )
            /*if (character.status.uppercase() == CharactersStatus.DEAD.name) {
                binding.imageViewCharacterPhoto.convertToGrayscale()
            } else binding.imageViewCharacterPhoto.colorFilter = null*/
            binding.imageViewCharacterPhoto.loadPhoto(url = character.image, radius = 100)
            binding.customViewCharacterInfo.setData(
                mainText = character.name,
                afterText = character.species.plus(", ").plus(character.gender),
                buttonText = character.location.name,
                endText = CharactersStatus.valueOf(character.status.uppercase())
            )
        }
    }
}
