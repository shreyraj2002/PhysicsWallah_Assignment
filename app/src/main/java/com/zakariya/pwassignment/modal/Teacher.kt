package com.zakariya.pwassignment.modal

data class Teacher(
    val id: Int,
    val name: String,
    val profileImage: String,
    val qualification: List<String>,
    val subjects: List<String>
)