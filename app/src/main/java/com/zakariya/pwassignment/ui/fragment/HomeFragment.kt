package com.zakariya.pwassignment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zakariya.pwassignment.adapter.HomeRecyclerAdapter
import com.zakariya.pwassignment.databinding.FragmentHomeBinding
import com.zakariya.pwassignment.model.Teacher
import com.zakariya.pwassignment.ui.TeachersViewModel
import com.zakariya.pwassignment.ui.activity.MainActivity

class HomeFragment : Fragment(), HomeRecyclerAdapter.OnTeacherClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: TeachersViewModel
    private lateinit var homeRecyclerAdapter: HomeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.progressBar.visibility = View.VISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = (activity as MainActivity).viewModel

        homeRecyclerAdapter = HomeRecyclerAdapter(requireContext(), this)
        setupRecyclerAdapter()

        viewModel.teachersData.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.VISIBLE
            homeRecyclerAdapter.sendDataToAdapter(it)
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun setupRecyclerAdapter() = binding.homeRecyclerView.apply {
        adapter = homeRecyclerAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onClickListener(data: Teacher) {
        Toast.makeText(requireContext(), "Hi! this is ${data.name}", Toast.LENGTH_LONG).show()
    }
}