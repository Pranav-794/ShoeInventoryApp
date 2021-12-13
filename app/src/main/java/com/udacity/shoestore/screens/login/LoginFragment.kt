package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {
    /**
     * Lazily initialize our [LoginViewModel].
     */
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = LoginFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.apply {
            registerButton.setOnClickListener {
                viewModel.onRegister(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())
            }
            loginButton.setOnClickListener {
                viewModel.onLogin(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())
            }
        }

        viewModel.loginState.observe(this as LifecycleOwner, { state ->
            when(state) {
                LoginState.REGISTERED -> {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                    viewModel.onLoginComplete()
                }
                LoginState.LOGGED_IN -> {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                    viewModel.onLoginComplete()
                }
            }
        })
        return binding.root
    }
}