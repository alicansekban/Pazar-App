package com.alican.mvvm_starter.ui

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alican.mvvm_starter.R
import com.alican.mvvm_starter.base.BaseActivity
import com.alican.mvvm_starter.databinding.ActivityMainBinding
import com.alican.mvvm_starter.util.utils.setupWithNavControllerView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(),
    NavController.OnDestinationChangedListener {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
    }


    private fun initNavigation() {


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navMainFragment) as NavHostFragment
        navController = navHostFragment.navController
        // Setup the bottom navigation view with navController
        binding.bottomNavigation.setupWithNavController(navController)
        binding.bottomNavigation.itemIconTintList = null

        // Setup the ActionBar with navController and 3 top level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.mapFragment,
                R.id.profileFragment,
            )
        )
        navHostFragment.navController.addOnDestinationChangedListener(this)
        //binding.toolbar.materialToolbar.setNavigationOnClickListener { navController.popBackStack() }
        val menu = binding.bottomNavigation.menu

        binding.bottomNavigation.setOnItemReselectedListener {
            when (it.title) {
                "Anasayfa" -> {
                    navHostFragment.findNavController().navigate(R.id.homeFragment)
                }

                "Arama" -> {
                    navHostFragment.findNavController().navigate(R.id.searchFragment)
                }

                "Harita" -> {

                    navHostFragment.findNavController().navigate(R.id.mapFragment)
                }

                "Profile" -> {

                    navHostFragment.findNavController().navigate(R.id.profileFragment)
                }
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener,
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.title) {
                    "Anasayfa" -> {
                        navHostFragment.findNavController().navigate(R.id.main_nav)
                    }

                    "Arama" -> {
                        navHostFragment.findNavController().navigate(R.id.search_nav)
                    }

                    "Harita" -> {

                        navHostFragment.findNavController().navigate(R.id.map_nav)
                    }

                    "Profile" -> {
                        navHostFragment.findNavController().navigate(R.id.profile_nav)
                    }
                }
                return true
            }
        })
    }


    override fun getLayoutId(): Int = R.layout.activity_main
    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {

        binding.bottomNavigation.menu.forEach {
            it.isEnabled = false
        }
        Handler().postDelayed({
            binding.bottomNavigation.menu.forEach {
                it.isEnabled = true
            }
        }, 500)
    }
}
