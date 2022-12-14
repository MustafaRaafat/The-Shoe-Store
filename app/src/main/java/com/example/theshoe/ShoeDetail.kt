package com.example.theshoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.theshoe.databinding.FragmentShoeDetailBinding
import com.example.theshoe.viewmodel.ShoeViewModel

class ShoeDetail : Fragment() {

    private var _binding: FragmentShoeDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel

        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
        }
        binding.saveButton.setOnClickListener {
            viewModel.addToTheList()
            it.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}