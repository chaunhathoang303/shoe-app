package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentOnboardingBinding


class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentOnboardingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_onboarding, container, false
        )
        binding.onBoardingButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToInstructionFragment())
        }
        return binding.root


    }


}