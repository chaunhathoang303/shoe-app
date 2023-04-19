package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeDetailViewModel
import com.udacity.shoestore.models.ShoeDetailViewModelFactory

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeDetailViewModel

    private lateinit var binding: FragmentShoeDetailBinding

    private lateinit var viewDetailModelFactory: ShoeDetailViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        val shoeDetailFragmentArgs by navArgs<ShoeDetailFragmentArgs>()

        viewDetailModelFactory = ShoeDetailViewModelFactory(shoeDetailFragmentArgs.shoes)

        viewModel =
            ViewModelProvider(this, viewDetailModelFactory).get(ShoeDetailViewModel::class.java)

        binding.shoeDetailViewModel = viewModel

        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener { view: View ->
            viewModel.setCompany(binding.editTextCompany.text.toString())
            viewModel.setName(binding.editTextName.text.toString())
            viewModel.setSize(binding.editTextSize.text.toString())
            viewModel.setDescription(binding.editTextDescription.text.toString())
            viewModel.onSave()
            Navigation.findNavController(view)
                .navigate(
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeFragment(
                        viewModel.shoe.value
                    )
                )
        }

        binding.cancelButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeFragment(
                    viewModel.shoe.value
                )
            )
        }


        return binding.root
    }

}