package com.example.celebritychat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.celebritychat.data.Repository
import com.example.celebritychat.data.model.Contact
import com.example.celebritychat.data.model.Messages
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private var _contact = MutableLiveData<List<Contact>>()
    val contact: LiveData<List<Contact>>
        get() = _contact

    private var _messages = MutableLiveData<MutableList<Messages>>()
    val messages: LiveData<MutableList<Messages>>
        get() = _messages

    init {
        _contact.value = repository.loadContacts()
    }

    fun loadMessages(name: String) {
        val contact = _contact.value?.find { it.name == name }

        if (contact != null) {
            _messages.value = contact.messages
        }
    }

    fun sendMessage(message: String, contactName: String?) {
        if (!message.isNullOrEmpty()) {
            _messages.value?.add(0, Messages(message, false))
            _messages.value = _messages.value

            viewModelScope.launch {
                delay(2000)
                _messages.value?.add(0, Messages(generateAnswer(), true))
                _messages.value = _messages.value
            }
        }
    }


    fun generateAnswer(): String {
        val randomGenerator = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).random()
        val answer = when (randomGenerator) {
            1 -> "What's up?"
            2 -> "I know you!"
            3 -> "Can you say that again f2f?"
            4 -> "Dude how did you find my number!?"
            5 -> "WHO ARE YOU!?!?"
            6 -> "Many thanks"
            7 -> "You will make it one day too!"
            8 -> "I may need to see the booty"
            9 -> "Not bad"
            else -> "..."
        }
        return answer
    }
}