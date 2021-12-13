package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeRowContentBinding

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
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

        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToShoeDetailFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.logout_item -> findNavController().navigate(ShoeListFragmentDirections.actionShoeListToLoginFragment3())
        }
        return true
    }

}