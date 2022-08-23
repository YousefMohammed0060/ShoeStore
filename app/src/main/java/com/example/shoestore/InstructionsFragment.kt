package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentInstractionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstractionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instractions, container, false)

        binding.shoeListBtn.setOnClickListener {
            it.findNavController().navigate(InstructionsFragmentDirections.actionInstractionsFragmentToShoeListFragment())
        }
        return binding.root
    }

}