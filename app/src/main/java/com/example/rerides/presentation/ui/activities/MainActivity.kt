package com.example.rerides.presentation.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.rerides.R
import com.example.rerides.databinding.ActivityMainBinding
import com.example.rerides.presentation.ui.fragments.*


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //footer onclick function
        replacefragment(MainFragment())
        binding.bottomnavigationbar.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.footer_home -> replacefragment(MainFragment())
                R.id.footer_navigation -> replacefragment(NavigationFragment())
                R.id.footer_re -> replacefragment(MyREFragment())
                R.id.footer_shop -> replacefragment(ShopFragment())
                R.id.footer_rides -> replacefragment(RideFragment())

                else -> {

                }
            }
            true
        }
    }


    private fun replacefragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentLayoutContainer.id,fragment)
        Log.i("Message","Content")
        fragmentTransaction.commit()
    }
}