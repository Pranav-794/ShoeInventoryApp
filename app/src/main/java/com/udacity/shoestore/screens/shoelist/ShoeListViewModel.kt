package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = listOf<Shoe>(Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),
            Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),
            Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),
            Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),
            Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),
            Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),
            Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),
            Shoe("Air Forces", 9.5, "Nike", "Jump further with these!"),)
    }
}