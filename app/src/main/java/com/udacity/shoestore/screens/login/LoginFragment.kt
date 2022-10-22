package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

@Suppress("DEPRECATION")
class loginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.signInBtn.setOnClickListener {
            val action = loginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            navController.navigate(action)
        }

        binding.signUpBtn.setOnClickListener {
            val action = loginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            navController.navigate(action)
        }
    }


}