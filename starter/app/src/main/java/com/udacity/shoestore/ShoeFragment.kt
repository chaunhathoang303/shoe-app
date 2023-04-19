package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.models.ShoeViewModelFactory
import com.udacity.shoestore.models.ShoeViewModel

class ShoeFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    private lateinit var binding: FragmentShoeBinding

    private lateinit var viewModelFactory: ShoeViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe, container, false
        )

        val shoeFragmentArgs by navArgs<ShoeFragmentArgs>()

        viewModelFactory = ShoeViewModelFactory(shoeFragmentArgs.shoes)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeViewModel::class.java)

        binding.shoeViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.listShoe.observe(viewLifecycleOwner, Observer { newListShoe ->
            binding.shoeList.adapter = ShoeItemAdapter(requireActivity(), newListShoe)
        })

        binding.floatingButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(ShoeFragmentDirections.actionShoeFragmentToShoeDetailFragment(viewModel.listShoe.value))
        }


        return binding.root
    }

}