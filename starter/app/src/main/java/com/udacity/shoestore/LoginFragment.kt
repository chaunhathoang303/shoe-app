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
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel

        binding.lifecycleOwner = this

        binding.longinButton.setOnClickListener { view: View ->
            viewModel.getUserName(binding.editTextEmailAddress.text.toString())
            viewModel.getPassword(binding.editTextPassword.text.toString())
            viewModel.onLogin()
            viewModel.eventLogin.observe(viewLifecycleOwner, Observer { isLogin ->
                if (isLogin) {
                    Navigation.findNavController(view)
                        .navigate(LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment())

                }
            })
        }


        return binding.root
    }
}