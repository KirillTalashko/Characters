package com.example.characters.presentation.utils.extension

import com.example.characters.data.model.Character

fun Character.gender() = this.species.plus(", ").plus(this.gender)