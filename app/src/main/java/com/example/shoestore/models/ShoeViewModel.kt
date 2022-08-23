package com.example.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<Shoe>()
    val shoeList: LiveData<Shoe>
        get() = _shoeList

    var list=ArrayList<Shoe>()

    init {
    }

    fun addNewShoe(shoe: Shoe) {
        _shoeList.value =shoe
        list.add(shoe)
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

}