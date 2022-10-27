package com.udacity.shoestore.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    var name: MutableLiveData<String> = MutableLiveData()
    var company: MutableLiveData<String> = MutableLiveData()
    var description: MutableLiveData<String> = MutableLiveData()
    var size: MutableLiveData<Double> = MutableLiveData()
    //var shoe : Shoe = Shoe("" , 0.0 , "" , "")

    fun setName(name1: CharSequence) {
        name.value = name1.toString()
    }

    fun setSize(size1: CharSequence) {
        size.value = size1.toString().toDouble()
    }

    fun setCompany(brand: CharSequence) {
        company.value = brand.toString()
    }

    fun setDescription(description1: CharSequence) {
        description.value = description1.toString()
    }


    private var _list: MutableLiveData<List<Shoe>> = MutableLiveData()
    val list: LiveData<List<Shoe>> = _list

    fun saveInput() {
        var shoe = Shoe(
            name.value.toString(),
            size.value.toString().toDouble(),
            company.value.toString(),
            description.value.toString()
        )
        val oldList = _list.value?.toMutableList().orEmpty()
        val newList = oldList.plus(shoe)

        _list.value = newList
    }


}