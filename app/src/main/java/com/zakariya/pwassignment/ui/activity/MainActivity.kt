package com.zakariya.pwassignment.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.zakariya.pwassignment.R
import com.zakariya.pwassignment.databinding.ActivityMainBinding
import com.zakariya.pwassignment.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = MaterialToolbar(this)
        setSupportActionBar(toolbar)

        binding.toolBar.title = "Home"

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentFrame, HomeFragment())
            .commit()
    }
}