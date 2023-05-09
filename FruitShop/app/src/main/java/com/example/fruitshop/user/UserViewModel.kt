package com.example.fruitshop.user

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class UserViewModel(val dao: RoomDao): ViewModel() {


    var name = ""
    var password = ""


    private val user = dao.getAll()

    fun addUSer() {
        viewModelScope.launch {
            val user = RoomEntity()
            user.roomName = name
            user.roomPassword = password
            dao.insert(user)
        }
    }

    fun signUpUser(name: String): Boolean {
        var isUserInDatabase = false
        runBlocking {
            withContext(Dispatchers.IO) {
                val names = dao.getAllNames()
                for (i in names.indices) {
                    if (names[i] == name) {
                        isUserInDatabase = true
                        break
                    }
                }
            }
        }
        return isUserInDatabase
    }

    fun signInUser(
        name: String,
        password: String
    ): Boolean { // puedes usar una corrutina para realizar la consulta en un hilo separado, o usar el método postValue() de LiveData para enviar el resultado a la UI desde un hilo separado.
        var isUserInDatabase = false
        runBlocking {
            withContext(Dispatchers.IO) {
                val names = dao.getAllNames()
                val passwords = dao.getAllPasswords()
                for (i in names.indices) {
                    if (names[i] == name && passwords[i] == password) {
                        isUserInDatabase = true
                        break
                    }
                }
            }
        }
        return isUserInDatabase
    }
}
