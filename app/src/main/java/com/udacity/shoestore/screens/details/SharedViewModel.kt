package com.udacity.shoestore.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {
    var name: MutableLiveData<String> = MutableLiveData<String>()
    var description: MutableLiveData<String> = MutableLiveData<String>()
    var brand: MutableLiveData<String> = MutableLiveData<String>()
    var size = MutableLiveData<Double>()

    private var _list : MutableLiveData<List<Shoe>> = MutableLiveData()
    val list : LiveData<List<Shoe>> = _list
    fun addShoe(name1 : String , size1 : Double , company1 : String , description1 : String) {
        val shoe = Shoe(name1 , size1 , company1 , description1)
        val oldList = _list.value?.toMutableList().orEmpty()
        val newList = oldList.plus(shoe)

        _list.value = newList
    }
}