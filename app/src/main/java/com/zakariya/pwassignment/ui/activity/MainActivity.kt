package com.zakariya.pwassignment.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zakariya.pwassignment.R
import com.zakariya.pwassignment.databinding.ActivityMainBinding
import com.zakariya.pwassignment.repository.TeachersRepository
import com.zakariya.pwassignment.ui.TeacherViewModelProviderFactory
import com.zakariya.pwassignment.ui.TeachersViewModel
import com.zakariya.pwassignment.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: TeachersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.title = "Home"

        val teachersRepository = TeachersRepository()
        val viewModelProviderFactory = TeacherViewModelProviderFactory(teachersRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[TeachersViewModel::class.java]

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentFrame, HomeFragment())
            .commit()
    }
}