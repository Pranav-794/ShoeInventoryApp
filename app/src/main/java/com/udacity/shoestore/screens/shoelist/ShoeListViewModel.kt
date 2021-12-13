package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

enum class SavedState {
    ON_SAVE, SAVE_ERROR, NO_OP
}

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _savedState = MutableLiveData<SavedState>()
    val savedState: LiveData<SavedState>
        get() = _savedState

    init {
        _shoeList.value = mutableListOf(Shoe("Air Forces II", "9.5 US", "Nike", "The best Air Forces out there!"))
        _savedState.value = SavedState.NO_OP
    }

    fun onAddNewShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        _savedState.value = SavedState.ON_SAVE
    }

    fun onSaveComplete() {
        _savedState.value = SavedState.NO_OP
    }
}