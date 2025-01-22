package com.example.characters.presentation.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.characters.R
import com.example.characters.common.CharactersStatus
import com.example.characters.common.Core
import com.example.characters.data.model.Character
import com.example.characters.presentation.utils.extension.gender

class CommonCharacterInfoCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val textViewSpeciesAndGender: TextView
    private val textViewLocationText: TextView
    private val imageViewLocationImage: ImageView
    private val textViewStatus: TextView
    private val textViewName: TextView
    private val cardViewPlayCard: View
    private val textViewPlayName: TextView
    private val imageViewPlayImage: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view_common_character_info, this, true)

        textViewSpeciesAndGender = findViewById(R.id.text_view_species_and_gender)
        textViewLocationText = findViewById(R.id.text_view_location_text)
        imageViewLocationImage = findViewById(R.id.image_view_location_image)
        textViewStatus = findViewById(R.id.text_view_status)
        textViewName = findViewById(R.id.text_view_name)
        cardViewPlayCard = findViewById(R.id.card_view_play_card)
        textViewPlayName = findViewById(R.id.text_view_play_name)
        imageViewPlayImage = findViewById(R.id.image_view_play_image)
    }

    private fun setCardData(cardText: String?, cardImage: Int?) {

        cardViewPlayCard.background =
            ContextCompat.getDrawable(context, R.drawable.bg_play_card_orange)

        (cardViewPlayCard as CardView).radius =
            context.getString(R.string.corner_radius_play_card).toFloat()

        textViewPlayName.text = cardText ?: context.getString(R.string.watch_episodes)

        imageViewPlayImage.setImageDrawable(
            ContextCompat.getDrawable(context, cardImage ?: R.drawable.ic_play)
        )
    }

    fun setData(
        character: Character,
        buttonImage: Int? = null,
        cardText: String? = null,
        cardImage: Int? = null
    ) {
        textViewSpeciesAndGender.text = character.gender()
        textViewLocationText.text = character.location.name
        imageViewLocationImage.setImageDrawable(
            ContextCompat.getDrawable(context, buttonImage ?: R.drawable.ic_location)
        )

        setCardData(cardText, cardImage)
        changeInStatus(CharactersStatus.valueOf(character.status.uppercase()), character.name)
    }

    private fun changeInStatus(
        status: CharactersStatus, mainText: String
    ) {
        textViewStatus.text = status.name
        when (status) {
            CharactersStatus.ALIVE -> {
                textViewName.text = if (mainText.length >= Core.MAX_LENGTH_TEXT) {
                    mainText.substring(
                        startIndex = 0,
                        endIndex = context.getString(R.string.max_length).toInt()
                    ) + context.getString(
                        R.string.read_more
                    )
                } else mainText

                textViewStatus.setTextColor(
                    ContextCompat.getColor(context, R.color.green_for_text)
                )

                textViewStatus.background = ContextCompat.getDrawable(
                    context,
                    R.drawable.bg_status_card_green
                )
            }

            CharactersStatus.DEAD -> {
                textViewName.text = if (mainText.length >= Core.MAX_LENGTH_TEXT) {
                    mainText.substring(
                        startIndex = 0,
                        endIndex = context.getString(R.string.max_length).toInt()
                    ) + context.getString(
                        R.string.read_more
                    )
                } else mainText

                textViewStatus.setTextColor(
                    ContextCompat.getColor(context, R.color.red_for_text)
                )

                textViewStatus.background = ContextCompat.getDrawable(
                    context,
                    R.drawable.bg_status_card_red
                )
            }

            CharactersStatus.UNKNOWN -> {
                textViewName.text = if (mainText.length >= Core.MAX_LENGTH_TEXT) {
                    mainText.substring(
                        startIndex = 0,
                        endIndex = context.getString(R.string.min_length).toInt()
                    ) + context.getString(
                        R.string.read_more
                    )
                } else mainText

                textViewStatus.setTextColor(
                    ContextCompat.getColor(context, R.color.gray_for_text)
                )

                textViewStatus.background = ContextCompat.getDrawable(
                    context,
                    R.drawable.bg_status_card_gray
                )
            }
        }
    }
}