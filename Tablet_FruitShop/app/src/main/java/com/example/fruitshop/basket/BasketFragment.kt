package com.example.fruitshop.basket

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.bind
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitshop.*
import com.example.fruitshop.basket.recyclerView.ItemAdapter
import com.example.fruitshop.butcher.ButcherShopViewModel
import com.example.fruitshop.fishMarket.FishMarketViewModel
import com.example.fruitshop.fruitShop.FruitShopViewModel
import com.example.fruitshop.sportShop.SportShopViewModel
import com.example.fruitshop.databinding.FragmentBasketBinding
import com.example.fruitshop.user.NameUserViewModel

class BasketFragment : Fragment() {

    private lateinit var binding: FragmentBasketBinding

    private var itemList = ItemProvider.itemList

    private lateinit var adapter: ItemAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private val fruitShopViewModel: FruitShopViewModel by activityViewModels()
    private val butcherShopViewModel: ButcherShopViewModel by activityViewModels()
    private val fishMarketViewModel: FishMarketViewModel by activityViewModels()
    private val sportShopViewModel: SportShopViewModel by activityViewModels()
    private val basketViewModel: BasketViewModel by activityViewModels()
    private val nameUserViewModel: NameUserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemList.clear()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basket, container, false)

        basketViewModel.totalFinal.observe(viewLifecycleOwner, Observer {
            viewDelete()
            viewBuy()
        })

        userViews(nameUserViewModel.getUser())

        binding.deleteBasket.setOnClickListener{
            fruitShopViewModel.deleteItemFruit()
            fishMarketViewModel.deleteItemFish()
            butcherShopViewModel.deleteItemMeat()
            sportShopViewModel.deleteItemSport()
            totalView()
            viewDelete()
            itemDelete()
            viewBuy()
        }

        binding.buyAll.setOnClickListener {
            /*fruitShopViewModel.deleteItemFruit()
            fishMarketViewModel.deleteItemFish()
            butcherShopViewModel.deleteItemMeat()
            sportShopViewModel.deleteItemSport()
            totalView()
            viewDelete()
            itemDelete()
            viewBuy()*/
            findNavController().navigate(R.id.action_basketFragment_to_purchaseProcessFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRView()

    }

    fun initRView(){
        adapter = ItemAdapter(itemList, {removeItem(it)})

        layoutManager = LinearLayoutManager(context)

        binding.rView?.layoutManager = layoutManager
        binding.rView?.adapter = adapter


        fruitViews()
        fishViews()
        meatViews()
        viewsSport()
        totalView()
        adapter.actualizarAdapter(itemList)

    }

    private fun itemDelete() {
        itemList.clear()
        adapter.actualizarAdapter(itemList)
        adapter.notifyDataSetChanged()
    }

    /*fun userViews(name: String){
        binding.buyAll.isEnabled = name != ""
}*/

    fun userViews(name: String){
        if(name == ""){ //desactivamos el boton
            binding.buyAll.isEnabled = false
        }else{ //activamos el boton
            binding.buyAll.isEnabled = true
        }
    }

    //funcion para mostrar las views cuando cambia la orientacion
    @SuppressLint("SetTextI18n")
    fun fruitViews(){
        var item: Item
        if((fruitShopViewModel.apple.value ?: 0) > 0){
            item = Item(
                R.drawable.apple,
                getString(R.string.apple_text) + " " + fruitShopViewModel.apple.value.toString()
            )

            itemList.add(item)
        }
        if((fruitShopViewModel.pear.value ?: 0) > 0){
            item = Item(
                R.drawable.pear,
                getString(R.string.pear_text) + " " + fruitShopViewModel.pear.value.toString()
            )

            itemList.add(item)
        }
        if((fruitShopViewModel.orange.value ?: 0) > 0){
            item = Item(
                R.drawable.orange,
                getString(R.string.orange_text) + " " + fruitShopViewModel.orange.value.toString()
            )

            itemList.add(item)
        }
        if((fruitShopViewModel.plum.value ?: 0) > 0){
            item = Item(
                R.drawable.plum,
                getString(R.string.plum_text) + " " + fruitShopViewModel.plum.value.toString()
            )

            itemList.add(item)
        }
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    fun fishViews(){
        var item: Item
        if((fishMarketViewModel.salmon.value ?: 0) > 0){
            item = Item(
                R.drawable.salmon,
                getString(R.string.salmon_text) + " " + fishMarketViewModel.salmon.value.toString()
            )

            itemList.add(item)
        }
        if((fishMarketViewModel.gilt_head_bream.value ?: 0) > 0){
            item = Item(
                R.drawable.dorada,
                getString(R.string.gilt_head_bream_text) + " " + fishMarketViewModel.gilt_head_bream.value.toString()
            )

            itemList.add(item)
        }
        if((fishMarketViewModel.sea_bass.value ?: 0) > 0){
            item = Item(
                R.drawable.lubina,
                getString(R.string.sea_bass_text) + " " + fishMarketViewModel.sea_bass.value.toString()
            )

            itemList.add(item)
        }
        if((fishMarketViewModel.red_mullet.value ?: 0) > 0){
            item = Item(
                R.drawable.salmonete,
                getString(R.string.red_mullet_text) + " " + fishMarketViewModel.red_mullet.value.toString()
            )

            itemList.add(item)
        }
    }

    @SuppressLint("SetTextI18n")
    fun meatViews(){
        var item: Item
        if((butcherShopViewModel.cow.value ?: 0) > 0){
            item = Item(
                R.drawable.cow,
                getString(R.string.cow_text) + " " + butcherShopViewModel.cow.value.toString()
            )

            itemList.add(item)
        }
        if((butcherShopViewModel.chicken.value ?: 0) > 0){
            item = Item(
                R.drawable.chicken,
                getString(R.string.chicken_text) + " " + butcherShopViewModel.chicken.value.toString()
            )

            itemList.add(item)
        }
        if((butcherShopViewModel.pig.value ?: 0) > 0){
            item = Item(
                R.drawable.pig,
                getString(R.string.pig_text) + " " + butcherShopViewModel.pig.value.toString()
            )

            itemList.add(item)
        }
        if((butcherShopViewModel.mince.value ?: 0) > 0){
            item = Item(
                R.drawable.mince,
                getString(R.string.mince_text) + " " + butcherShopViewModel.mince.value.toString()
            )

            itemList.add(item)
        }
    }

    @SuppressLint("SetTextI18n")
    fun viewsSport(){
        var item: Item
        if((sportShopViewModel.ballSoccer.value ?: 0) > 0){
            item = Item(
                R.drawable.soccer,
                getString(R.string.ball_soccer_text) + " " + sportShopViewModel.ballSoccer.value.toString()
            )

            itemList.add(item)
        }
        if((sportShopViewModel.ballBasket.value ?: 0) > 0){
            item = Item(
                R.drawable.ball_basket,
                getString(R.string.ball_basket_text) + " " + sportShopViewModel.ballBasket.value.toString()
            )

            itemList.add(item)
        }
        if((sportShopViewModel.ballTennis.value ?: 0) > 0){
            item = Item(
                R.drawable.tennis,
                getString(R.string.ball_tennis_text) + " " + sportShopViewModel.ballTennis.value.toString()
            )

            itemList.add(item)
        }
        if((sportShopViewModel.ballBaseball.value ?: 0) > 0){
            item = Item(
                R.drawable.baseball,
                getString(R.string.ball_baseball_text) + " " + sportShopViewModel.ballBaseball.value.toString()
            )

            itemList.add(item)
        }
    }

    fun viewDelete(){
        if((basketViewModel.totalFinal.value ?: 0.0) > 0.0){
            binding.deleteBasket.visibility = View.VISIBLE
        }else{
            binding.deleteBasket.visibility = View.GONE
        }
    }

    fun viewBuy(){
        if((basketViewModel.totalFinal.value ?: 0.0) > 0.0){
            binding.buyAll.visibility = View.VISIBLE
        }else{
            binding.buyAll.visibility = View.GONE
        }
    }

    @SuppressLint("SetTextI18n")
    fun totalView(){
        if((basketViewModel.totalFinal.value ?: 0.0) > 0.0){
            basketViewModel.calculatePriceFinal(fruitShopViewModel.getTotalFruit(), fishMarketViewModel.getTotalFish(), butcherShopViewModel.getTotalMeat(), sportShopViewModel.getTotalSport())
            binding.totalText.text = getString(R.string.total)+" "+ String.format("%.2f",basketViewModel.totalFinal.value) +"€"
        }else{
            basketViewModel.calculatePriceFinal(fruitShopViewModel.getTotalFruit(), fishMarketViewModel.getTotalFish(), butcherShopViewModel.getTotalMeat(), sportShopViewModel.getTotalSport())
            binding.totalText.text = getString(R.string.total)+" "+ String.format("%.2f",basketViewModel.totalFinal.value) +"€"
        }
    }

    fun removeItem(position: Int){
        var name_product = itemList[position].itemImage

        when(name_product) {
            R.drawable.apple -> {
                fruitShopViewModel.deleteApple()
                fruitShopViewModel.calculatePriceFruit()
            }
            R.drawable.pear -> {
                fruitShopViewModel.deletePear()
                fruitShopViewModel.calculatePriceFruit()
            }
            R.drawable.orange -> {
                fruitShopViewModel.deleteOrange()
                fruitShopViewModel.calculatePriceFruit()
            }
            R.drawable.plum -> {
                fruitShopViewModel.deletePlum()
                fruitShopViewModel.calculatePriceFruit()
            }
            R.drawable.salmon -> {
                fishMarketViewModel.deleteSalmon()
                fishMarketViewModel.calculatePriceFish()
            }
            R.drawable.dorada -> {
                fishMarketViewModel.deleteGiltHeadBream()
                fishMarketViewModel.calculatePriceFish()
            }
            R.drawable.lubina -> {
                fishMarketViewModel.deleteSeaBass()
                fishMarketViewModel.calculatePriceFish()
            }
            R.drawable.salmonete -> {
                fishMarketViewModel.deleteRedMullet()
                fishMarketViewModel.calculatePriceFish()
            }
            R.drawable.cow -> {
                butcherShopViewModel.deleteCow()
                butcherShopViewModel.calculatePriceMeat()
            }
            R.drawable.pig -> {
                butcherShopViewModel.deletePig()
                butcherShopViewModel.calculatePriceMeat()
            }
            R.drawable.chicken -> {
                butcherShopViewModel.deleteChicken()
                butcherShopViewModel.calculatePriceMeat()
            }
            R.drawable.mince -> {
                butcherShopViewModel.deleteMince()
                butcherShopViewModel.calculatePriceMeat()
            }
            R.drawable.soccer -> {
                sportShopViewModel.deleteBallSoccer()
                sportShopViewModel.calculatePriceSport()
            }
            R.drawable.ball_basket -> {
                sportShopViewModel.deleteBallBasket()
                sportShopViewModel.calculatePriceSport()
            }
            R.drawable.baseball -> {
                sportShopViewModel.deleteBallBaseball()
                sportShopViewModel.calculatePriceSport()
            }
            R.drawable.tennis -> {
                sportShopViewModel.deleteBallTennis()
                sportShopViewModel.calculatePriceSport()
            }
        }

        itemList.removeAt(position)
        totalView()
        adapter.notifyItemRemoved(position)
    }
}

