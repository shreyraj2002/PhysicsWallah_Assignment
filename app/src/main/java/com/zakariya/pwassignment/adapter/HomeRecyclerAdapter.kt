package com.zakariya.pwassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zakariya.pwassignment.databinding.RecyclerHomeSingleItemBinding
import com.zakariya.pwassignment.model.Teacher

class HomeRecyclerAdapter :
    RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    private lateinit var teachersList: List<Teacher>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = RecyclerHomeSingleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = teachersList.size

    class HomeViewHolder(binding: RecyclerHomeSingleItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun sendDataToAdapter(_teachersList: List<Teacher>) {
        this.teachersList = _teachersList
        notifyDataSetChanged()
    }
}