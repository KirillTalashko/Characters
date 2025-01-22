package com.example.characters.presentation.utils

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.characters.R
import com.example.characters.common.CharactersStatus
import com.example.characters.common.Core
import com.example.characters.databinding.CustomViewCommonCharacterInfoBinding

class CommonCharacterInfoCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: CustomViewCommonCharacterInfoBinding? = null

    init {
        binding =
            CustomViewCommonCharacterInfoBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setData(
        mainText: String,
        afterText: String,
        buttonImage: Int? = null,
        buttonText: String,
        cardText: String? = null,
        cardImage: Int? = null,
        endText: CharactersStatus
    ) {
        binding?.apply {
            textViewStatus.invalidate()
            textViewSpeciesAndGender.text = afterText
            textViewLocationText.text = buttonText
            imageViewLocationImage.setImageDrawable(
                ContextCompat.getDrawable(
                    this.root.context,
                    buttonImage ?: R.drawable.ic_location
                )
            )
        }
        setIncludeData(cardText, cardImage)
        changeInStatus(endText, mainText)
    }

    private fun changeInStatus(
        status: CharactersStatus, mainText: String
    ) {
        Log.i("youTag", "customView ${status.name}")
        when (status) {
            CharactersStatus.ALIVE -> {
                binding?.apply {
                    Log.i("youTag", "запись ${status.name}")
                    textViewStatus.text = status.name
                    textViewName.text = if (mainText.length >= Core.MAX_LENGTH_TEXT) {
                        mainText.substring(0, 15) + "..."
                    } else mainText
                    textViewStatus.setTextColor(
                        ContextCompat.getColor(
                            this.root.context,
                            R.color.green_for_text
                        )
                    )
                    textViewStatus.background =
                        ContextCompat.getDrawable(
                            this.root.context,
                            R.drawable.bg_status_card_green
                        )
                }
            }

            CharactersStatus.DEAD -> {
                binding?.apply {
                    Log.i("youTag", "запись ${status.name}")
                    textViewStatus.text = status.name
                    textViewName.text = if (mainText.length >= Core.MAX_LENGTH_TEXT) {
                        mainText.substring(0, 15) + "..."
                    } else mainText
                    textViewStatus.setTextColor(
                        ContextCompat.getColor(
                            this.root.context,
                            R.color.red_for_text
                        )
                    )
                    textViewStatus.background =
                        ContextCompat.getDrawable(this.root.context, R.drawable.bg_status_card_red)
                }
            }

            CharactersStatus.UNKNOWN -> {
                binding?.apply {
                    textViewStatus.invalidate()
                    Log.i("youTag", "запись ${status.name}")
                    textViewStatus.text = status.name
                    textViewName.text = if (mainText.length >= Core.MAX_LENGTH_TEXT) {
                        mainText.substring(0, 12) + "..."
                    } else mainText
                    textViewStatus.setTextColor(
                        ContextCompat.getColor(
                            this.root.context,
                            R.color.gray_for_text
                        )
                    )
                    textViewStatus.background =
                        ContextCompat.getDrawable(this.root.context, R.drawable.bg_status_card_gray)
                }
            }
        }
    }

    private fun setIncludeData(cardText: String?, cardImage: Int?) {
        binding?.apply {
            includeContainer.cardViewPlayCard.setCardBackgroundColor(
                ContextCompat.getColor(
                    this.root.context,
                    R.color.orange_for_card
                )
            )

            includeContainer.textViewPlayName.text =
                cardText ?: ContextCompat.getString(this.root.context, R.string.watch_episodes)

            includeContainer.imageViewPlayImage.setImageDrawable(
                ContextCompat.getDrawable(
                    this.root.context,
                    cardImage ?: R.drawable.ic_play
                )
            )
        }
    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        binding = null
    }

}