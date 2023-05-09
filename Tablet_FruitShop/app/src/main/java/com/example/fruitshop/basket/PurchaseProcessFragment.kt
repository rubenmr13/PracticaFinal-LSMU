package com.example.fruitshop.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fruitshop.R
import com.example.fruitshop.butcher.ButcherShopViewModel
import com.example.fruitshop.databinding.FragmentPurchaseProcessBinding
import com.example.fruitshop.fishMarket.FishMarketViewModel
import com.example.fruitshop.fruitShop.FruitShopViewModel
import com.example.fruitshop.sportShop.SportShopViewModel

class PurchaseProcessFragment : Fragment() {

    private val fruitShopViewModel: FruitShopViewModel by activityViewModels()
    private val butcherShopViewModel: ButcherShopViewModel by activityViewModels()
    private val fishMarketViewModel: FishMarketViewModel by activityViewModels()
    private val sportShopViewModel: SportShopViewModel by activityViewModels()

    private lateinit var binding: FragmentPurchaseProcessBinding
    private lateinit var viewModel: PurchaseProcessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPurchaseProcessBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(PurchaseProcessViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBuy.setOnClickListener {
            if(
                (viewModel.tryCardNumber(binding.cardNumber.text.toString())) &&
                (viewModel.tryExpirationDate(binding.expirationDate.text.toString())) &&
                (viewModel.tryCVC(binding.cvcText.text.toString())) &&
                (viewModel.tryNumber(binding.etNumber.text.toString())) &&
                (!binding.etCity.text.toString().isEmpty()) &&
                (!binding.etStreet.text.toString().isEmpty()) &&
                (!binding.etCountry.text.toString().isEmpty())
            ){
                findNavController().navigate(R.id.action_purchaseProcessFragment_to_purchaseCompletedFragment)
                fruitShopViewModel.deleteItemFruit()
                fishMarketViewModel.deleteItemFish()
                butcherShopViewModel.deleteItemMeat()
                sportShopViewModel.deleteItemSport()
            } else{
                Toast.makeText(requireContext(), R.string.wrong_field, Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonBasket.setOnClickListener{
            findNavController().navigate(R.id.action_purchaseProcessFragment_to_basketFragment)
        }
    }
}