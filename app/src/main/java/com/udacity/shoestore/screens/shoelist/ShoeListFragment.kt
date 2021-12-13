package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeRowContentBinding

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ShoeListFragmentBinding.inflate(inflater)

        binding.apply {
            for (shoe in viewModel.shoeList.value!!) {
                val shoeRowBinding = ShoeRowContentBinding.inflate(layoutInflater)
                shoeRowBinding.shoeObject = shoe
                binding.shoeList.addView(shoeRowBinding.root)
            }
        }

        return binding.root
    }

}