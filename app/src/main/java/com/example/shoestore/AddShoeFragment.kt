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
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentAddShoeBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.models.ShoeViewModel


class AddShoeFragment : Fragment() {
    lateinit var binding: FragmentAddShoeBinding
    private lateinit var viewModel: ShoeViewModel
    lateinit var image:Uri
    lateinit var bitmap:Bitmap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.saveBtn.setOnClickListener {

            var name = binding.shoeNameText.text.toString()
            var company = binding.shoeCompanyText.text.toString()
            var description = binding.shoeDescriptionText.text.toString()
            var size = binding.shoeSizeText.text.toString()
            if (name!="" && size!="" && company!="" && description!="" && bitmap!=null ){
                var shoe = Shoe(name, size, company, description, bitmap)
                viewModel.addNewShoe(shoe)
                findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragment2ToShoeListFragment())
            }
        }

        binding.shoeImageView.setOnClickListener{
            pickImage()
        }

        return binding.root
    }

    fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            binding.shoeImageView.setImageURI(data?.data)
            image = data?.data!!
            bitmap= MediaStore.Images.Media.getBitmap(context?.contentResolver,image)
        }
    }

}