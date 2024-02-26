package com.example.pruebakosmosandroid.ui.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.pruebakosmosandroid.R
import com.example.pruebakosmosandroid.databinding.ActivityMainBinding
import com.example.pruebakosmosandroid.ui.fragment.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val splashScreen = installSplashScreen()

        initNavigationBottom()
        val fragment = ProfileFragment.newInstance()
        openFragment(fragment)
    }

    private fun initNavigationBottom() {
        binding.botNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_profile -> {
                    val fragment = ProfileFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}