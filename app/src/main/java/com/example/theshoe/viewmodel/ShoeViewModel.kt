package com.example.theshoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theshoe.models.Shoe

class ShoeViewModel : ViewModel() {
    private var shoesList = mutableListOf<Shoe>()
    private var shoes = MutableLiveData<List<Shoe>>()

    fun addToTheList(shoe: Shoe) {
        shoesList.add(shoe)
        shoes.value = shoesList
    }

    fun getList(): LiveData<List<Shoe>> {
        return shoes
    }
}