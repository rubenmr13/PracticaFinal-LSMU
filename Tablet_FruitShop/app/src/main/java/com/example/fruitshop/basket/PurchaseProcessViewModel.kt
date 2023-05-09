package com.example.fruitshop.basket

import androidx.lifecycle.ViewModel

class PurchaseProcessViewModel: ViewModel() {


    fun tryCardNumber(cardNumber: String): Boolean{
        if(cardNumber.toLongOrNull() == null){
            return false
        }
        if(cardNumber.length != 16){
            return false
        }
        return true
    }

    fun tryExpirationDate(expirationDate: String): Boolean{
        val patron = Regex("""^\d+/\d+$""")
        if(!patron.matches(expirationDate)){
            return false
        }
        val mes = expirationDate.split("/")[0].toInt()
        if((mes > 12) || (mes == 0)){
            return false
        }
        val anio = expirationDate.split("/")[1].toInt()
        if(anio < 23){
            return false
        }
        return true
    }

    fun tryCVC(cvc: String): Boolean{
        if(cvc.toIntOrNull() == null){
            return false
        }
        if(cvc.length != 3){
            return false
        }
        return true
    }

    fun tryNumber(number: String): Boolean {
        if(number.toIntOrNull() == null){
            return false
        }
        return true
    }
}