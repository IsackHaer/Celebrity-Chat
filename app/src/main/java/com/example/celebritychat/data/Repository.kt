package com.example.celebritychat.data

import com.example.celebritychat.R
import com.example.celebritychat.data.model.Contact
import com.example.celebritychat.data.model.Messages

class Repository {

    fun loadContacts(): List<Contact>{
        return listOf<Contact>(
            Contact("Brad", R.drawable.brad, mutableListOf()),
            Contact("Emma", R.drawable.emma, mutableListOf()),
            Contact("Jennifer", R.drawable.jennifer, mutableListOf()),
            Contact("Johnny", R.drawable.johnny, mutableListOf()),
            Contact("Keanu", R.drawable.keanu, mutableListOf()),
            Contact("Leo", R.drawable.leo, mutableListOf()),
            Contact("Margot", R.drawable.margot, mutableListOf()),
            Contact("Reese", R.drawable.reese, mutableListOf()),
            Contact("Sandra", R.drawable.sandra, mutableListOf()),
            Contact("Scarlett", R.drawable.scarlett, mutableListOf()),
            Contact("Tom", R.drawable.tom, mutableListOf()),
            Contact("Will", R.drawable.will, mutableListOf())
        )
    }
}