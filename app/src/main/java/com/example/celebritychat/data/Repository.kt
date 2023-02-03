package com.example.celebritychat.data

import com.example.celebritychat.R
import com.example.celebritychat.data.model.Contact
import com.example.celebritychat.data.model.Messages

class Repository {

    fun loadContacts(): List<Contact>{
        return listOf<Contact>(
            Contact("Brad", R.drawable.brad, mutableListOf(Messages("Is anyone there?",false))),
            Contact("Emma", R.drawable.emma, mutableListOf(Messages("Oh no.. not you again..", true))),
            Contact("Jennifer", R.drawable.jennifer, mutableListOf(Messages("Hey you!",true))),
            Contact("Johnny", R.drawable.johnny, mutableListOf(Messages("didn't I tell you not to stalke me..", true))),
            Contact("Keanu", R.drawable.keanu, mutableListOf(Messages("Blue pill or red pill?",true))),
            Contact("Leo", R.drawable.leo, mutableListOf(Messages("Hello beautiful",false))),
            Contact("Margot", R.drawable.margot, mutableListOf(Messages("I've seen your new movie!",false))),
            Contact("Reese", R.drawable.reese, mutableListOf()),
            Contact("Sandra", R.drawable.sandra, mutableListOf()),
            Contact("Scarlett", R.drawable.scarlett, mutableListOf()),
            Contact("Tom", R.drawable.tom, mutableListOf()),
            Contact("Will", R.drawable.will, mutableListOf())
        )
    }
}