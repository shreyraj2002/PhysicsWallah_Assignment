package com.zakariya.pwassignment.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zakariya.pwassignment.adapter.HomeRecyclerAdapter
import com.zakariya.pwassignment.databinding.FragmentHomeBinding
import com.zakariya.pwassignment.ui.TeachersViewModel
import com.zakariya.pwassignment.ui.activity.MainActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: TeachersViewModel
    lateinit var homeRecyclerAdapter: HomeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = (activity as MainActivity).viewModel

    }
}