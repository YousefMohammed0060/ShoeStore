package com.example.shoestore

import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.AddShoeRowBinding
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    //private val noteDatabase by lazy { ToDoDatabase.getInstance(requireContext()).todoDataBaseDao }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        setupItemsView(inflater, container)
        binding.addShoeBtn.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment2())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun setupItemsView(inflater: LayoutInflater, container: ViewGroup?) {
        viewModel.list
        binding.parentLinearLayout.removeAllViews()
        for (shoeItem in viewModel.list) {
            val itemsBinding: AddShoeRowBinding =
                DataBindingUtil.inflate(inflater, R.layout.add_shoe_row, container, false)

            itemsBinding.sizeTv.setText(shoeItem.size.toString())
            itemsBinding.shoeIv.setImageURI(Uri.parse(shoeItem.image))
            itemsBinding.shoe = shoeItem
            itemsBinding.constraintView.setOnClickListener {

            }
            binding.parentLinearLayout.addView(itemsBinding.root)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.loginFragment -> navigateAbout(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateAbout(item: MenuItem) {

        view?.findNavController()
            ?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment2())

    }

}

