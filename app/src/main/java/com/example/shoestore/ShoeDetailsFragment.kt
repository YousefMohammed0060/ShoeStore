package com.example.shoestore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.shoestore.databinding.FragmentAddShoeBinding
import com.example.shoestore.databinding.FragmentShoeDetailsBinding
import com.example.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        val argument = ShoeDetailsFragmentArgs.fromBundle(requireArguments())

        binding.shoe =Shoe(argument.name,argument.size,argument.company,argument.description)

        return binding.root
    }

}