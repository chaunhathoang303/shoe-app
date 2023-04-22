package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.longinButton.setOnClickListener { view: View ->
            if (binding.editTextEmailAddress.text.toString() == "abc@gmail.com" && (binding.editTextPassword.text.toString() == "123456")) {
                Navigation.findNavController(view)
                    .navigate(LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment())
            }

        }

        return binding.root
    }
}