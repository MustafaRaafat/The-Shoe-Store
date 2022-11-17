package com.example.theshoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.theshoe.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {

    private var _binding: FragmentWelcomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeScreen_to_instruction)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}