package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoeFragment : Fragment() {

    private val sharedViewModel: ShoeViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe, container, false
        )

        binding.shoeViewModel = sharedViewModel

        binding.lifecycleOwner = this

        val linearLayout = binding.shoeListContainer

        sharedViewModel.listShoe.observe(viewLifecycleOwner, Observer { newListShoe ->
            for (Shoe in newListShoe) {
                val shoeItemView =
                    LayoutInflater.from(context).inflate(R.layout.shoe_item, linearLayout, false)

                shoeItemView.findViewById<TextView>(R.id.shoeName).text = Shoe.name
                shoeItemView.findViewById<TextView>(R.id.shoeCompany).text = Shoe.company
                shoeItemView.findViewById<TextView>(R.id.shoeSize).text = Shoe.size.toString()
                shoeItemView.findViewById<TextView>(R.id.shoeDescription).text = Shoe.description

                linearLayout.addView(shoeItemView)
            }
        })

        binding.floatingButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(ShoeFragmentDirections.actionShoeFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}