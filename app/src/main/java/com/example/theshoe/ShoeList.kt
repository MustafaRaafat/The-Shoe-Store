package com.example.theshoe

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.theshoe.databinding.FragmentShoeListBinding
import com.example.theshoe.models.Shoe
import com.example.theshoe.viewmodel.ShoeViewModel

class ShoeList : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
        }
        shoeViewModel.getList().observe(viewLifecycleOwner, Observer { shoe ->
            updateUi(shoe)
        })

    }

    private fun updateUi(shoes: List<Shoe>) {
        for (shoe in shoes) {
            val name = TextView(this.context)
            name.text = shoe.name
            name.layoutParams =
                ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            binding.shoeListLinearlayout.addView(name)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.log_out -> {
                findNavController().popBackStack()
                findNavController().navigate(R.id.login)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}