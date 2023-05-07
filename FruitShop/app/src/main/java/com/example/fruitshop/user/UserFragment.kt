package com.example.fruitshop.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fruitshop.R
import com.example.fruitshop.basket.BasketViewModel
import com.example.fruitshop.databinding.FragmentUserBinding


class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private val nameUserViewModel: NameUserViewModel by activityViewModels() // lo necesito para guardar el estado del usuario
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)

        val application = requireNotNull(this.activity).application
        val dao = RoomDataBase.getInstance(application).roomDao

        val viewModelFactory = UserViewModelFactory(dao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        nameUserViewModel.nameUser.observe(viewLifecycleOwner, Observer { newUser ->
            if(newUser !=""){
                binding.textUserWelcome.text = getString(R.string.text_user_welcome)+" "+ newUser.toString()
            }
            viewsUser()
        })
        viewsUser()


        binding.signIn.setOnClickListener { //iniciar sesion
            if(viewModel.name !="" && viewModel.password != "") {
                val existsUser = viewModel.signUpUser(viewModel.name)
                if(existsUser){
                    val existsUserPassword = viewModel.signInUser(viewModel.name , viewModel.password)
                    if(existsUserPassword){ //si existe el usuario y la contraseña
                        nameUserViewModel.addUser(viewModel.name)
                        binding.userEditText.setText("")
                        binding.passwordEditText.setText("")
                        findNavController().navigate(R.id.action_userFragment_self)
                    }else{//si existe el usuario pero no la contraseña
                        Toast.makeText(context, R.string.text_incorrect_password, Toast.LENGTH_SHORT).show()
                    }
                }else{ //si el usuario no existe
                    Toast.makeText(context, R.string.text_user_no_registered, Toast.LENGTH_SHORT).show()
                }
            }
        }


        binding.signUp.setOnClickListener { //registrarse
            if (viewModel.name != "" && viewModel.password != "") { //si se han escrito los dos campos
                val existsUser = viewModel.signUpUser(viewModel.name) //devuelve true si el usuario ya existe
                if (!existsUser) { //Si no existe el usuario lo creo
                    nameUserViewModel.addUser(viewModel.name)
                    viewModel.addUSer()
                    binding.userEditText.setText("")
                    binding.passwordEditText.setText("")
                    findNavController().navigate(R.id.action_userFragment_self)
                }else{//si el usuario existe
                    Toast.makeText(context, R.string.text_registered_user, Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.logOut.setOnClickListener { //cerrar sesion
            var nameUser = ""
            nameUserViewModel.addUser(nameUser)
            binding.textUserWelcome.text = ""
            viewsUser()
        }


        return binding.root
    }

    fun viewsUser(){
        if(binding.textUserWelcome.text.toString().trim().isEmpty()){
            binding.userEditText.visibility = View.VISIBLE
            binding.passwordEditText.visibility = View.VISIBLE
            binding.signIn.visibility = View.VISIBLE
            binding.signUp.visibility = View.VISIBLE
            binding.textUserWelcome.visibility = View.GONE
            binding.logOut.visibility = View.GONE

        }else{
            binding.userEditText.visibility = View.GONE
            binding.passwordEditText.visibility = View.GONE
            binding.signIn.visibility = View.GONE
            binding.signUp.visibility = View.GONE
            binding.textUserWelcome.visibility = View.VISIBLE
            binding.logOut.visibility = View.VISIBLE
        }
    }
}
