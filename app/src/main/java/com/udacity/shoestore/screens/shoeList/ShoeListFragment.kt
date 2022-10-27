package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeCardBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.add_card.AddCard
import com.udacity.shoestore.screens.details.SharedViewModel
import kotlinx.android.synthetic.main.shoe_card.view.*


@Suppress("DEPRECATION")
class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar
    private lateinit var card: ShoeCardBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // adding toolbar
        toolbar = binding.myToolbar
        var activity: AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        // add view model
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)



        Log.i("Adham", "List size from shoe list${viewModel.list.value}")
        viewModel.list.observe(requireActivity(), Observer {
            binding.linearLayoutContainer.removeAllViews()
            for (shoe in it) {
                card = AddCard(this.requireContext()).view
                card.shoeName.text = "Name : ${shoe.name}"
                card.description.text = "Description : ${shoe.description}"
                card.brandTextCard.text = "Brand : ${shoe.company}"
                card.sizeTextCard.text = "Size : ${shoe.size}"
                binding.linearLayoutContainer.addView(card.root)
            }
        })
        Log.i("Adham", "number of child ${binding.linearLayoutContainer.childCount}")
        binding.addBtn.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToMakeShoeFragment()
            navController.navigate(action)

        }


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}
