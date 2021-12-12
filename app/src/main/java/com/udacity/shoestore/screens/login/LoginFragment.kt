package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = LoginFragmentBinding.inflate(inflater)

        binding.apply {
            registerButton.setOnClickListener {
                viewModel.onRegister(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())
            }
            loginButton.setOnClickListener {
                viewModel.onLogin(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())
            }
        }

        viewModel.loginState.observe(viewLifecycleOwner, { state ->
            when(state) {
                LoginState.REGISTERED -> {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                }
                LoginState.LOGGED_IN -> {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                }
            }
        })
        return binding.root
    }
}