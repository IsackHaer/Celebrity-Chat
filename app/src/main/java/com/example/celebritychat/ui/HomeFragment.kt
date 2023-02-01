package com.example.celebritychat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.celebritychat.MainViewModel
import com.example.celebritychat.adapter.ContactListAdapter
import com.example.celebritychat.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val contactAdapter = ContactListAdapter()
        binding.homeRv.adapter = contactAdapter

        viewModel.contact.observe(viewLifecycleOwner) {
            contactAdapter.submitList(it)
        }
    }
}