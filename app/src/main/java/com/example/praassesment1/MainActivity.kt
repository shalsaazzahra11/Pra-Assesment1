package com.example.praassesment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.*
import androidx.navigation.Navigation
import com.example.praassesment1.databinding.ActivityMainBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        val navController = this.findNavController(R.id.navigation)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.navigation)
        return super.onSupportNavigateUp()
    }
}
