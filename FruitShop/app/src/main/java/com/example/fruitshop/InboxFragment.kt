package com.example.fruitshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.fruitshop.databinding.FragmentInboxBinding
import com.example.fruitshop.user.NameUserViewModel

class InboxFragment : Fragment() {

    private lateinit var binding: FragmentInboxBinding
    private val inboxViewModel: ShopViewModel by activityViewModels()
    private val nameUserViewModel: NameUserViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_inbox, container, false)

        viewsChat(nameUserViewModel.getUser())
        viewDeleteMessage()

        inboxViewModel.messageChat.observe(viewLifecycleOwner, Observer {
            binding.messageInbox.text = inboxViewModel.getMessageChat()
            viewDeleteMessage()
        })

        binding.deleteMessage.setOnClickListener{
            inboxViewModel.deleteMessage()
            viewDeleteMessage()
        }

        return binding.root
    }



    fun viewsChat(name:String){
        if(name == ""){
            binding.yourMessageInbox.visibility = View.GONE
            binding.messageInbox.visibility = View.GONE
            binding.deleteMessage.visibility = View.GONE
            binding.unregisteredUser.visibility = View.VISIBLE
            inboxViewModel.deleteMessage()

        }else{
            binding.yourMessageInbox.visibility = View.VISIBLE
            binding.messageInbox.visibility = View.VISIBLE
            binding.deleteMessage.visibility = View.VISIBLE
            binding.unregisteredUser.visibility = View.GONE
        }
    }

    fun viewDeleteMessage(){
        if(binding.messageInbox.text.toString().trim().isEmpty()){
            binding.deleteMessage.visibility = View.GONE
        }else{
            binding.deleteMessage.visibility = View.VISIBLE
        }
    }
}