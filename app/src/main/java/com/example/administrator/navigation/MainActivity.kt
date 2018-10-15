package com.example.administrator.navigation

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val host = NavHostFragment.create(R.navigation.navigation)
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.mainBlankFragment, host)
//            .setPrimaryNavigationFragment(host)
//            .commit()
        val navigationView = findViewById<NavigationView>(R.id.navigationMain)
        NavigationUI.setupWithNavController(navigationView, findNavController(mainBlankFragment))
    }

    override fun onSupportNavigateUp() = findNavController(mainBlankFragment).navigateUp()


}
