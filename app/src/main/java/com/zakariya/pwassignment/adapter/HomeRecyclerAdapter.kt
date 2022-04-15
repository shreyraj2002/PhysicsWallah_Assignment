package com.zakariya.pwassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zakariya.pwassignment.databinding.RecyclerHomeSingleItemBinding
import com.zakariya.pwassignment.model.Teacher

class HomeRecyclerAdapter(val context: Context) :
    RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    private var teachersList: List<Teacher> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = RecyclerHomeSingleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val teacher = teachersList[position]

        holder.binding.txtName.text = teacher.name
        holder.binding.txtSubject.text = teacher.subjects.first()
        holder.binding.txtQualification.text = teacher.qualification.first()
        Glide.with(context).load(teacher.profileImage).into(holder.binding.imgTeacher)
    }

    override fun getItemCount(): Int = teachersList.size

    class HomeViewHolder(val binding: RecyclerHomeSingleItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun sendDataToAdapter(_teachersList: List<Teacher>) {
        this.teachersList = _teachersList
        notifyDataSetChanged()
    }
}