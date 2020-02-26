package com.example.praassesment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : Fragment() {
    private lateinit var binding: MainFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(R.layout.fragment_main, false)
        binding.main = this
        binding.bt_pp.setOnClickListener {
            view?.findNavController()
                ?.navigate(MainFragmentDirections.actionMainFragmentTopersegiPanjang)
        }
        binding.bt_sgta.setOnClickListener {
            view?.findNavController()
                ?.navigate(MainFragmentDirections.actionMainFragmentTosegitiga)
        }

        setHasOptionsMenu(true)
        return binding.root
        }
    }
}