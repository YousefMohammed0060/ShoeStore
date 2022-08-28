package com.example.shoestore

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentAddShoeBinding
import com.example.shoestore.models.Hints
import com.example.shoestore.models.Shoe
import com.example.shoestore.models.ShoeViewModel


class AddShoeFragment : Fragment() {
    lateinit var binding: FragmentAddShoeBinding
    private lateinit var viewModel: ShoeViewModel

    private var oldItem = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shoe = Shoe()

        binding.saveBtn.setOnClickListener {
            var name = binding.shoe?.name  ?: ""
            var company = binding.shoe?.company ?: ""
            var description = binding.shoe?.description ?: ""
            var size = binding.shoe?.size ?: ""
            if (name!="" && size!="" && company!="" && description!="" ){
                var shoe = Shoe(name, size, company, description)
                viewModel.addNewShoe(shoe)
                findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragment2ToShoeListFragment())
            }else{
                Toast.makeText(
                    context,
                    "Shoe is Empty",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }


}