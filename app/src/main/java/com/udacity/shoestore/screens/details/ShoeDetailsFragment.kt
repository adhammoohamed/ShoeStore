package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentMakeShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMakeShoeBinding
    private lateinit var navController: NavController

    private lateinit var viewModel: SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_make_shoe, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.lifecycleOwner = this
        binding.shoe = viewModel


        binding.makeShoeBtn.setOnClickListener {
            //save userInput
            viewModel.saveInput()
            val action = ShoeDetailsFragmentDirections.actionMakeShoeFragmentToShoeListFragment()
            navController.navigate(action)
        }

        binding.cancelBtn.setOnClickListener {
            binding.nameEditText.text.clear()
            binding.brandEditText.text.clear()
            binding.descriptionEditText.text.clear()
            binding.sizeEditText.text.clear()
        }

    }

}
