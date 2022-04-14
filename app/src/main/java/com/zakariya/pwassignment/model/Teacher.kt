package com.zakariya.pwassignment.model

data class Teacher(
    val id: Int,
    val name: String,
    val profileImage: String,
    val qualification: List<String>,
    val subjects: List<String>
)