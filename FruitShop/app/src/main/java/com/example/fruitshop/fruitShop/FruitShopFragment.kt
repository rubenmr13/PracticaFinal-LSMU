package com.example.fruitshop.fruitShop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.fruitshop.R
import com.example.fruitshop.databinding.FragmentFruitShopBinding

class FruitShopFragment : Fragment() {



    private lateinit var binding: FragmentFruitShopBinding
    private val fruitShopViewModel: FruitShopViewModel by activityViewModels()

    var fruits = mutableListOf<String>()
    lateinit var images : List<Int>



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fruit_shop, container, false)

        var quantity_number = 0

        fruitShopViewModel.totalFruit.observe(viewLifecycleOwner, Observer { newTotalFruit ->
            binding.totalText.text = getString(R.string.total)+" "+ String.format("%.2f",newTotalFruit) +"€"
        })

        fruitShopViewModel.apple.observe(viewLifecycleOwner, Observer { newApple ->
            binding.appleText.text = getString(R.string.apple_text) + " " +newApple.toString() ////aqui hacemos lo del apple
        })

        fruitShopViewModel.pear.observe(viewLifecycleOwner, Observer { newPear ->
            binding.pearText.text = getString(R.string.pear_text) + " " + newPear.toString()
        })

        fruitShopViewModel.orange.observe(viewLifecycleOwner, Observer { newOrange ->
            binding.orangeText.text = getString(R.string.orange_text) + " " + newOrange.toString()
        })

        fruitShopViewModel.plum.observe(viewLifecycleOwner, Observer { newPlum ->
            binding.plumText.text = getString(R.string.plum_text) + " " + newPlum.toString()
        })

        fruitShopViewModel.fruit.observe(viewLifecycleOwner, Observer{ newFruit ->
            if(newFruit == getString(R.string.selected_fruit)){
                noSelectedFruit()
            }else{ //si se ha seleccionado una fruta mostramos esa fruta
                selectedFruit(quantity_number)
            }
        })

        fruitShopViewModel.saveFruit(getString(R.string.selected_fruit))

        fruits = init_fruit()
        images = init_image()

        val adapter = ImageFruitAdapt()
        binding.spinnerFruitShop.adapter = adapter


        //vemos que hemos seleccionado con el spinner
        binding.spinnerFruitShop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                views(binding.appleText, binding.pearText, binding.orangeText, binding.plumText, binding.appleImage,
                    binding.pearImage, binding.orangeImage, binding.plumImage, binding.deleteBasket,
                    binding.btnRemoveApple, binding.btnRemovePear, binding.btnRemoveOrange, binding.btnRemovePlum) //Muestra las views cuando cambia la orientacion
                fruitShopViewModel.saveFruit(binding.spinnerFruitShop.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                quantity_number = progress
                binding.textQuantitySelected.text = getString(R.string.text_quantity_selected)+ " "+quantity_number+"/100"
                binding.priceFruitText.text = getString(R.string.price_fruit_text)+" "+ String.format("%.2f",fruitShopViewModel.calculateFruit(quantity_number, this@FruitShopFragment)) +"€"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Este método se llama cuando el usuario toca la SeekBar
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Este método se llama cuando el usuario levanta el dedo de la SeekBar
            }
        })

        binding.addFruit.setOnClickListener {
            fruitShopViewModel.addFruit(quantity_number, this) //añadimos la fruta al bundle

            binding.seekBar.progress=0 //ponemos a 0 el seekBar
            fruitShopViewModel.calculatePriceFruit() //calculamos el precio y lo añadimos al bundle
            views(binding.appleText, binding.pearText, binding.orangeText , binding.plumText,
                binding.appleImage, binding.pearImage, binding.orangeImage, binding.plumImage,
                binding.deleteBasket,
                binding.btnRemoveApple, binding.btnRemovePear, binding.btnRemoveOrange, binding.btnRemovePlum)
        }

        binding.deleteBasket.setOnClickListener{
            fruitShopViewModel.deleteItemFruit()
            binding.seekBar.progress=0
            views(binding.appleText, binding.pearText, binding.orangeText , binding.plumText,binding.appleImage, binding.pearImage,
                binding.orangeImage, binding.plumImage, binding.deleteBasket,
                binding.btnRemoveApple, binding.btnRemovePear, binding.btnRemoveOrange, binding.btnRemovePlum)
        }

        binding.btnRemoveApple.setOnClickListener {
            fruitShopViewModel.deleteApple()
            fruitShopViewModel.calculatePriceFruit()

            fruitShopViewModel.calculatePriceFruit()
            views(binding.appleText, binding.pearText, binding.orangeText , binding.plumText,
                binding.appleImage, binding.pearImage, binding.orangeImage, binding.plumImage,
                binding.deleteBasket,
                binding.btnRemoveApple, binding.btnRemovePear, binding.btnRemoveOrange, binding.btnRemovePlum)
        }

        binding.btnRemovePear.setOnClickListener {
            fruitShopViewModel.deletePear()
            fruitShopViewModel.calculatePriceFruit()

            views(binding.appleText, binding.pearText, binding.orangeText , binding.plumText,
                binding.appleImage, binding.pearImage, binding.orangeImage, binding.plumImage,
                binding.deleteBasket,
                binding.btnRemoveApple, binding.btnRemovePear, binding.btnRemoveOrange, binding.btnRemovePlum)
        }

        binding.btnRemoveOrange.setOnClickListener {
            fruitShopViewModel.deleteOrange()
            fruitShopViewModel.calculatePriceFruit()

            views(binding.appleText, binding.pearText, binding.orangeText , binding.plumText,
                binding.appleImage, binding.pearImage, binding.orangeImage, binding.plumImage,
                binding.deleteBasket,
                binding.btnRemoveApple, binding.btnRemovePear, binding.btnRemoveOrange, binding.btnRemovePlum)
        }

        binding.btnRemovePlum.setOnClickListener {
            fruitShopViewModel.deletePlum()
            fruitShopViewModel.calculatePriceFruit()

            views(binding.appleText, binding.pearText, binding.orangeText , binding.plumText,
                binding.appleImage, binding.pearImage, binding.orangeImage, binding.plumImage,
                binding.deleteBasket,
                binding.btnRemoveApple, binding.btnRemovePear, binding.btnRemoveOrange, binding.btnRemovePlum)
        }

        binding.basketImage.setOnClickListener {
            findNavController().navigate(R.id.action_fruitShopFragment_to_basketFragment)
        }

        return binding.root
    }

    inner class ImageFruitAdapt : BaseAdapter() {

        override fun getCount(): Int {
            return fruits.size
        }

        override fun getItem(position: Int): Any {
            return fruits[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }
        @SuppressLint("MissingInflatedId")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val convertview = LayoutInflater.from(context).inflate(R.layout.itemspinner, parent, false)

            val imageView = convertview.findViewById<ImageView>(R.id.imageView)
            val tv1 = convertview.findViewById<TextView>(R.id.item_type)

            imageView.setImageResource(images[position])
            tv1.text = fruits[position]

            return convertview
        }
    }

    fun noSelectedFruit(){
        binding.addFruit.visibility = View.GONE //no mostramos la vista
        binding.seekBar.visibility = View.GONE
        binding.textQuantitySelected.visibility = View.GONE
        binding.priceFruitText.visibility = View.GONE
        binding.deleteBasket.visibility = View.GONE
        binding.priceUnitFruitText.visibility = View.GONE

        if((fruitShopViewModel.totalFruit.value ?: 0.0) > 0.0){
            binding.deleteBasket.visibility = View.VISIBLE
        }else{
            binding.deleteBasket.visibility = View.GONE
        }
    }

    fun selectedFruit(quantity_number: Int){
        binding.addFruit.visibility = View.VISIBLE
        binding.seekBar.visibility = View.VISIBLE
        binding.textQuantitySelected.visibility = View.VISIBLE
        binding.priceFruitText.visibility = View.VISIBLE
        binding.seekBar.progress = 0 //ponemos a 0 el seekBar
        binding.priceUnitFruitText.visibility = View.VISIBLE

        if((fruitShopViewModel.totalFruit.value ?: 0.0) > 0.0){
            binding.deleteBasket.visibility = View.VISIBLE
        }else{
            binding.deleteBasket.visibility = View.GONE
        }

        binding.textQuantitySelected.text = getString(R.string.text_quantity_selected)+ " "+quantity_number+"/100"
        binding.priceFruitText.text = getString(R.string.price_fruit_text)+" "+ String.format("%.2f",fruitShopViewModel.calculateFruit(quantity_number, this )) +"€"
        val price_unit = fruitShopViewModel.priceUnitFruit(this@FruitShopFragment)
        binding.priceUnitFruitText.text = getString(R.string.price_unit_fruit_text)+" "+ price_unit.toString() + "€"
    }

    fun active_views(fruit_text: TextView, fruit_image: ImageView, fruit_button: ImageView){
        fruit_text.visibility = View.VISIBLE //mostramos la vista
        fruit_image.visibility = View.VISIBLE
        fruit_button.visibility = View.VISIBLE
    }

    fun desactive_views(fruit_text: TextView, fruit_image: ImageView, fruit_button: ImageView){
        fruit_text.visibility = View.GONE //mostramos la vista
        fruit_image.visibility = View.GONE
        fruit_button.visibility = View.GONE
    }

    //funcion para mostrar las views cuando cambia la orientacion
    fun views(apple_text: TextView, pear_text: TextView, orange_text: TextView,
              plum_text: TextView, apple_image: ImageView, pear_image: ImageView,
              orange_image: ImageView, plum_image: ImageView, delete_basket: Button,
              apple_button: ImageView, pear_button: ImageView, orange_button: ImageView, plum_button: ImageView
    ){

        if((fruitShopViewModel.apple.value ?: 0) > 0){
            active_views(apple_text, apple_image, apple_button)
        }else{
            desactive_views(apple_text, apple_image, apple_button)
        }
        if((fruitShopViewModel.pear.value ?: 0) > 0){
            active_views(pear_text, pear_image, pear_button)
        }else{
            desactive_views(pear_text, pear_image, pear_button)
        }
        if((fruitShopViewModel.orange.value ?: 0) > 0){
            active_views(orange_text, orange_image, orange_button)
        }else{
            desactive_views(orange_text, orange_image, orange_button)
        }
        if((fruitShopViewModel.plum.value ?: 0) > 0){
            active_views(plum_text, plum_image, plum_button)
        }else{
            desactive_views(plum_text, plum_image, plum_button)
        }
        if((fruitShopViewModel.totalFruit.value ?: 0.0) > 0.0){
            delete_basket.visibility = View.VISIBLE
        }else{
            delete_basket.visibility = View.GONE
        }
    }

    // inicializa la lista del spinner //no se puede quitar
    fun init_fruit(): MutableList<String>{
        val fruits = mutableListOf<String>()
        fruits.add(getString(R.string.selected_fruit))
        fruits.add(getString(R.string.apple))
        fruits.add(getString(R.string.pear))
        fruits.add(getString(R.string.orange))
        fruits.add(getString(R.string.plum))
        return fruits
    }

    //inicializar las imagenes //no se puede quitar
    fun init_image(): List<Int> {
        return listOf(
            R.drawable.white,
            R.drawable.apple,
            R.drawable.pear,
            R.drawable.orange,
            R.drawable.plum
        )
    }
}