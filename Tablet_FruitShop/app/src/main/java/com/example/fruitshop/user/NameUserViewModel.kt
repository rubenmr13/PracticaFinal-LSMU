package com.example.fruitshop.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameUserViewModel : ViewModel() {
    /// guardo el nombre del usuario

    private val _nameUser = MutableLiveData<String>()
    val nameUser: LiveData<String>
        get() = _nameUser

    init{
        if(_nameUser.value == null){
            _nameUser.value = ""
        }
    }

    fun addUser(name: String){
        _nameUser.value = name
    }
    fun getUser(): String{
        return _nameUser.value.toString()
    }


}