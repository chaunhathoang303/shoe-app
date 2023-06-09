package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val sharedViewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        binding.shoeViewModel = sharedViewModel

        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener { view: View ->
            sharedViewModel.addShoe()
            Navigation.findNavController(view)
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeFragment())
        }

        binding.cancelButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeFragment()
            )
        }


        return binding.root
    }

}