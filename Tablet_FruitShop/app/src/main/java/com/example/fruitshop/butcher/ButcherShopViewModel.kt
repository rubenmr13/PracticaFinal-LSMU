package com.example.fruitshop.butcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fruitshop.R
import com.example.fruitshop.butcher.ButcherShopFragment

class ButcherShopViewModel: ViewModel() {
    val COW_PRICE = 3.00
    val CHICKEN_PRICE = 4.50
    val PIG_PRICE = 1.00
    val MINCE_PRICE = 4.00


    private val _meat = MutableLiveData<String>()
    val meat: LiveData<String>
        get() = _meat

    private val _totalMeat = MutableLiveData<Double>()
    val totalMeat: LiveData<Double>
        get() = _totalMeat

    private val _cow = MutableLiveData<Int>()
    val cow: LiveData<Int>
        get() = _cow

    private val _chicken = MutableLiveData<Int>()
    val chicken: LiveData<Int>
        get() = _chicken

    private val _pig = MutableLiveData<Int>()
    val pig: LiveData<Int>
        get() = _pig

    private val _mince = MutableLiveData<Int>()
    val mince: LiveData<Int>
        get() = _mince


    fun priceUnitMeat(context : ButcherShopFragment): Double{
        return when (_meat.value){
            context.getString(R.string.cow)-> COW_PRICE
            context.getString(R.string.chicken) -> CHICKEN_PRICE
            context.getString(R.string.pig) -> PIG_PRICE
            context.getString(R.string.mince) -> MINCE_PRICE
            else -> 0.00
        }
    }

    fun addMeat(quantity_number: Int, context: ButcherShopFragment){
        val number: Int

        if(_meat.value == context.getString(R.string.cow)){
            number = _cow.value ?: 0
            _cow.value = number + quantity_number
        }else if(_meat.value == (context.getString(R.string.chicken))){
            number = _chicken.value ?: 0
            _chicken.value = number + quantity_number
        }else if(_meat.value == context.getString(R.string.pig)){
            number = _pig.value ?: 0
            _pig.value = number + quantity_number
        }else if(_meat.value == context.getString(R.string.mince)){
            number = _mince.value ?: 0
            _mince.value = number + quantity_number
        }
    }


    fun deleteItemMeat(){
        _cow.value = 0
        _chicken.value = 0
        _pig.value = 0
        _mince.value = 0
        _totalMeat.value = 0.0
    }


    fun calculatePriceMeat(){
        val cowCount = _cow.value?: 0
        val chickenCount = _chicken.value?: 0
        val pigCount = _pig.value?: 0
        val minceCount = _mince.value?: 0

        val total = cowCount * COW_PRICE + chickenCount * CHICKEN_PRICE +
                pigCount * PIG_PRICE + minceCount * MINCE_PRICE
        _totalMeat.value = total
    }

    fun calculateMeat(quantity_number: Int, context: ButcherShopFragment): Double{
        val total: Double
        if(_meat.value == context.getString(R.string.cow)){
            total = quantity_number * COW_PRICE
        }else if(_meat.value == context.getString(R.string.chicken)){
            total = quantity_number * CHICKEN_PRICE
        }else if(_meat.value == context.getString(R.string.pig)){
            total = quantity_number * PIG_PRICE
        }else{
            total = quantity_number * MINCE_PRICE
        }
        return total
    }

    fun saveMeat(meat: String){
        _meat.value = meat
    }

    fun getTotalMeat(): Double {
        val totalMeat = _totalMeat.value?:0.0
        return totalMeat
    }

    fun deleteCow() {
        val cowCount = _cow.value?: 0
        _totalMeat.value = _totalMeat.value?.minus(cowCount)
        _cow.value = 0
    }

    fun deletePig() {
        val pigCount = _pig.value?: 0
        _totalMeat.value = _totalMeat.value?.minus(pigCount)
        _pig.value = 0
    }

    fun deleteChicken() {
        val chickenCount = _chicken.value?: 0
        _totalMeat.value = _totalMeat.value?.minus(chickenCount)
        _chicken.value = 0
    }

    fun deleteMince() {
        val minceCount = _mince.value?: 0
        _totalMeat.value = _totalMeat.value?.minus(minceCount)
        _mince.value = 0
    }

}