package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class welcomeFragment : Fragment() {
    private lateinit var binding : FragmentWelcomeBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        navController = findNavController()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWelcomeBinding.bind(view)

        binding.nextWelcomeBtn.setOnClickListener {
            val action = welcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            navController.navigate(action)
        }
    }
}