package com.example.celebritychat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.celebritychat.data.Repository
import com.example.celebritychat.data.model.Contact

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private var _contact = MutableLiveData<List<Contact>>()
    val contact: LiveData<List<Contact>>
        get() = _contact

    private var _messages = MutableLiveData<MutableList<String>>()
    val messages: LiveData<MutableList<String>>
        get() = _messages

    init {
        _contact.value = repository.loadContacts()
    }

    fun loadMessages(name: String){
        val messages = _contact.value?.find { it.name == name }

        if (messages != null){
            _messages.value = messages.messages
        }
    }

    fun sendMessage(message: String){
        if (!message.isNullOrEmpty()) {
            _messages.value?.add(message)
            _messages.value = _messages.value
        }
    }
}