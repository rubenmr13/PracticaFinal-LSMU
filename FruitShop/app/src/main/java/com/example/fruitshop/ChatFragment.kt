package com.example.fruitshop

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.fruitshop.databinding.FragmentChatBinding
import com.example.fruitshop.user.NameUserViewModel


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val chatViewModel: ShopViewModel by activityViewModels()
    private val nameUserViewModel: NameUserViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)

        viewsChat(nameUserViewModel.getUser())

        chatViewModel.messageChat.observe(viewLifecycleOwner, Observer {
            binding.receivedText.text = chatViewModel.getMessageChat()
        })

        chatViewModel.initMessageChat()
        var text_chat = ""

        binding.sendText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                text_chat = s.toString()
            }
        })

        binding.sendButton.setOnClickListener{
            if(text_chat!=""){
                chatViewModel.addMessageChat(text_chat)
                binding.sendText.setText("") //borramos lo que hemos escrito en el editText
            }
        }

        return binding.root
    }

    fun viewsChat(name:String){
        if(name == ""){
            binding.sendText.visibility = View.GONE
            binding.sendButton.visibility = View.GONE
            binding.unregisteredUser.visibility = View.VISIBLE
            chatViewModel.deleteMessage()

        }else{
            binding.sendText.visibility = View.VISIBLE
            binding.sendButton.visibility = View.VISIBLE
            binding.unregisteredUser.visibility = View.GONE
        }
    }
}