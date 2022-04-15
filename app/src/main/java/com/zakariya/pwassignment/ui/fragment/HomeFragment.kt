package com.zakariya.pwassignment.ui.fragment

import android.os.Bundle
import android.util.Log
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
import com.zakariya.pwassignment.utils.Resource

class HomeFragment : Fragment(), HomeRecyclerAdapter.OnTeacherClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: TeachersViewModel
    private lateinit var homeRecyclerAdapter: HomeRecyclerAdapter

    val TAG = HomeFragment::class.simpleName

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

        viewModel.teachersData.observe(viewLifecycleOwner) { response ->

            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        homeRecyclerAdapter.sendDataToAdapter(it)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "Error: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

    override fun onClickListener(data: Teacher) {
        // Here we can show the details of teacher in a bottom_sheet or dialog etc. using Teacher object
        Toast.makeText(requireContext(), "Hi! this is ${data.name}", Toast.LENGTH_LONG).show()
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerAdapter() = binding.homeRecyclerView.apply {
        adapter = homeRecyclerAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}