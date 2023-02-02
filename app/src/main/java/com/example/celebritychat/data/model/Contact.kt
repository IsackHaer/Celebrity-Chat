package com.example.celebritychat.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Contact(
    val name: String,
    val image: Int,
    val messages: MutableList<Messages>
)