package com.example.celebritychat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.celebritychat.MainViewModel
import com.example.celebritychat.R
import com.example.celebritychat.adapter.MessageAdapter
import com.example.celebritychat.data.model.Contact
import com.example.celebritychat.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val contact = requireArguments().getString("contact")
        if (contact != null) {
            viewModel.loadMessages(contact)
        }

        val messageAdapter = MessageAdapter()
        binding.chatRv.adapter = messageAdapter

        binding.chatToolbar.title = contact
        binding.chatToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.messages.observe(viewLifecycleOwner){
            messageAdapter.submitMessages(it)
        }

        binding.chatSendBtn.setOnClickListener {
            val newMessage = binding.chatMessageEdit.text.toString()
            viewModel.sendMessage(newMessage, contact)
            binding.chatMessageEdit.text = null
        }


    }
}