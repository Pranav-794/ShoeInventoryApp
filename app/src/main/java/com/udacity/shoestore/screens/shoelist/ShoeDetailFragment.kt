package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    private val shoeObject = Shoe("", "0.0", "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ShoeDetailFragmentBinding.inflate(inflater)
        binding.shoeListViewModel = shoeListViewModel
        binding.lifecycleOwner = this
        binding.shoeObject = shoeObject

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeList())
        }
        
        shoeListViewModel.savedState.observe(viewLifecycleOwner, { state ->
            when(state) {
                com.udacity.shoestore.screens.shoelist.SavedState.ON_SAVE -> {
                    findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeList())
                    shoeListViewModel.onSaveComplete()
                }
            }
        })

        return binding.root
    }
}