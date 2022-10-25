package com.udacity.shoestore.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
class SharedViewModel : ViewModel()  {


    var shoe : Shoe = Shoe("" , 0.0 , "" , "")

    fun setName(name1: CharSequence) {
        shoe.name = name1.toString()
    }

    fun setSize(size1: CharSequence) {
        shoe.size = size1.toString().toDouble()
    }

    fun setCompany(brand: CharSequence) {
        shoe.company = brand.toString()
    }
    fun setDescription(description1: CharSequence) {
        shoe.description = description1.toString()
    }


    private var _list : MutableLiveData<List<Shoe>> = MutableLiveData()
    val list : LiveData<List<Shoe>> = _list

    fun saveInput (){
        shoe = Shoe(shoe.name , shoe.size , shoe.company , shoe.description)
        val oldList = _list.value?.toMutableList().orEmpty()
        val newList = oldList.plus(shoe)

        _list.value = newList
    }


}