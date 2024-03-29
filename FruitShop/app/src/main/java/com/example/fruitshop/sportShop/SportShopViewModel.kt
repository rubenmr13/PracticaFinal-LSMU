package com.example.fruitshop.sportShop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fruitshop.R
import com.example.fruitshop.butcher.ButcherShopFragment
import com.example.fruitshop.sportShop.SportShopFragment

class SportShopViewModel: ViewModel() {


    val BALL_SOCCER = 12.00
    val BALL_BASKET = 8.00
    val BALL_TENNIS = 2.50
    val BALL_BASEBALL = 4.00


    private val _sport = MutableLiveData<String>()
    val sport: LiveData<String>
        get() = _sport

    private val _totalSport = MutableLiveData<Double>()
    val totalSport: LiveData<Double>
        get() = _totalSport

    private val _ballSoccer = MutableLiveData<Int>()
    val ballSoccer: LiveData<Int>
        get() = _ballSoccer

    private val _ballBasket = MutableLiveData<Int>()
    val ballBasket: LiveData<Int>
        get() = _ballBasket

    private val _ballTennis = MutableLiveData<Int>()
    val ballTennis: LiveData<Int>
        get() = _ballTennis

    private val _ballBaseball = MutableLiveData<Int>()
    val ballBaseball: LiveData<Int>
        get() = _ballBaseball


    fun priceUnitMeat(context : SportShopFragment): Double{
        return when (_sport.value){
            context.getString(R.string.ball_soccer)-> BALL_SOCCER
            context.getString(R.string.ball_basket) -> BALL_BASKET
            context.getString(R.string.ball_tennis) -> BALL_TENNIS
            context.getString(R.string.ball_baseball) -> BALL_BASEBALL
            else -> 0.00
        }
    }

    fun addSport(quantity_number: Int, context: SportShopFragment){
        val number: Int

        if(_sport.value == context.getString(R.string.ball_soccer)){
            number = _ballSoccer.value ?: 0
            _ballSoccer.value = number + quantity_number
        }else if(_sport.value == (context.getString(R.string.ball_basket))){
            number = _ballBasket.value ?: 0
            _ballBasket.value = number + quantity_number
        }else if(_sport.value == context.getString(R.string.ball_tennis)){
            number = _ballTennis.value ?: 0
            _ballTennis.value = number + quantity_number
        }else if(_sport.value == context.getString(R.string.ball_baseball)){
            number = _ballBaseball.value ?: 0
            _ballBaseball.value = number + quantity_number
        }
    }


    fun deleteItemSport(){
        _ballSoccer.value = 0
        _ballBasket.value = 0
        _ballTennis.value = 0
        _ballBaseball.value = 0
        _totalSport.value = 0.0
    }


    fun calculatePriceSport(){
        val ballSoccerCount = _ballSoccer.value?: 0
        val ballBasketCount = _ballBasket.value?: 0
        val ballTennisCount = _ballTennis.value?: 0
        val ballBaseballCount = _ballBaseball.value?: 0

        val total = ballSoccerCount * BALL_SOCCER + ballBasketCount * BALL_BASKET +
                ballTennisCount * BALL_TENNIS + ballBaseballCount * BALL_BASEBALL
        _totalSport.value = total
    }

    fun calculateSport(quantity_number: Int, context: SportShopFragment): Double{
        val total: Double
        if(_sport.value == context.getString(R.string.ball_soccer)){
            total = quantity_number * BALL_SOCCER
        }else if(_sport.value == context.getString(R.string.ball_basket)){
            total = quantity_number * BALL_BASKET
        }else if(_sport.value == context.getString(R.string.ball_tennis)){
            total = quantity_number * BALL_TENNIS
        }else{
            total = quantity_number * BALL_BASEBALL
        }
        return total
    }

    fun saveSport(sport: String){
        _sport.value = sport
    }

    fun getTotalSport(): Double {
        val totalSport = _totalSport.value?:0.0
        return totalSport
    }

    fun deleteBallSoccer() {
        val soccerCount = _ballSoccer.value?: 0
        _totalSport.value = _totalSport.value?.minus(soccerCount)
        _ballSoccer.value = 0
    }

    fun deleteBallBasket() {
        val ballBasketCount = _ballBasket.value?: 0
        _totalSport.value = _totalSport.value?.minus(ballBasketCount)
        _ballBasket.value = 0
    }

    fun deleteBallBaseball() {
        val ballBaseballCount = _ballBaseball.value?: 0
        _totalSport.value = _totalSport.value?.minus(ballBaseballCount)
        _ballBaseball.value = 0
    }

    fun deleteBallTennis() {
        val ballTennisCount = _ballTennis.value?: 0
        _totalSport.value = _totalSport.value?.minus(ballTennisCount)
        _ballTennis.value = 0
    }
}