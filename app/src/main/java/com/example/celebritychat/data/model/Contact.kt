package com.example.celebritychat.data.model

data class Contact(
    val name: String,
    val image: Int,
    val messages: MutableList<String>
) {
}