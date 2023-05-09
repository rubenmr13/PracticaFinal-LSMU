package com.example.fruitshop.fruitShop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fruitshop.R
import com.example.fruitshop.butcher.ButcherShopFragment
import com.example.fruitshop.fruitShop.FruitShopFragment

class FruitShopViewModel: ViewModel() {

    //// FRUIT SHOP
    val APPLE_PRICE = 0.50
    val PEAR_PRICE = 0.40
    val ORANGE_PRICE = 0.25
    val PLUM_PRICE = 0.09


    private val _fruit = MutableLiveData<String>()
    val fruit: LiveData<String>
        get() = _fruit

    private val _totalFruit = MutableLiveData<Double>()
    val totalFruit: LiveData<Double>
        get() = _totalFruit

    private val _apple = MutableLiveData<Int>()
    val apple: LiveData<Int>
        get() = _apple

    private val _pear = MutableLiveData<Int>()
    val pear: LiveData<Int>
        get() = _pear

    private val _orange = MutableLiveData<Int>()
    val orange: LiveData<Int>
        get() = _orange

    private val _plum = MutableLiveData<Int>()
    val plum: LiveData<Int>
        get() = _plum

    fun priceUnitFruit(context : FruitShopFragment): Double{
        return when (_fruit.value){
            context.getString(R.string.apple)-> APPLE_PRICE
            context.getString(R.string.pear) -> PEAR_PRICE
            context.getString(R.string.orange) -> ORANGE_PRICE
            context.getString(R.string.plum) -> PLUM_PRICE
            else -> 0.00
        }
    }



    fun deleteItemFruit(){
        _apple.value = 0
        _pear.value = 0
        _orange.value = 0
        _plum.value = 0
        _totalFruit.value = 0.0
         //ponemos a 0 el seekBar
    }

    fun deleteApple(){
        val appleCount = _apple.value?: 0
        _totalFruit.value = _totalFruit.value?.minus(appleCount)
        _apple.value = 0
    }

    fun deletePear(){
        val pearCount = _pear.value?: 0
        _totalFruit.value = _totalFruit.value?.minus(pearCount)
        _pear.value = 0
    }

    fun deleteOrange(){
        val orangeCount = _orange.value?: 0
        _totalFruit.value = _totalFruit.value?.minus(orangeCount)
        _orange.value = 0
    }

    fun deletePlum(){
        val plumCount = _plum.value?: 0
        _totalFruit.value = _totalFruit.value?.minus(plumCount)
        _plum.value = 0
    }

    fun addFruit(quantity_number: Int, context: FruitShopFragment){
        val number: Int

        if(_fruit.value == context.getString(R.string.apple)){
            number = _apple.value ?: 0
            _apple.value = number + quantity_number
        }else if(_fruit.value == (context.getString(R.string.pear))){
            number = _pear.value ?: 0
            _pear.value = number + quantity_number
        }else if(_fruit.value == context.getString(R.string.orange)){
            number = _orange.value ?: 0
            _orange.value = number + quantity_number
        }else if(_fruit.value == context.getString(R.string.plum)){
            number = _plum.value ?: 0
            _plum.value = number + quantity_number
        }
    }

    fun calculatePriceFruit(){
        val appleCount = _apple.value?: 0
        val pearCount = _pear.value?: 0
        val orangeCount = _orange.value?: 0
        val plumCount = _plum.value?: 0

        val total = appleCount * APPLE_PRICE + pearCount * PEAR_PRICE +
                orangeCount * ORANGE_PRICE + plumCount * PLUM_PRICE
        _totalFruit.value = total
    }

    fun saveFruit(fruits: String){
        _fruit.value = fruits
    }

    fun calculateFruit(quantity_number: Int, context: FruitShopFragment): Double{
        val total: Double
        if(_fruit.value == context.getString(R.string.apple)){
            total = quantity_number * APPLE_PRICE
        }else if(_fruit.value == context.getString(R.string.pear)){
            total = quantity_number * PEAR_PRICE
        }else if(_fruit.value == context.getString(R.string.orange)){
            total = quantity_number * ORANGE_PRICE
        }else{
            total = quantity_number * PLUM_PRICE
        }
        return total
    }

    fun getTotalFruit(): Double {
        return _totalFruit.value?: 0.0
    }
}