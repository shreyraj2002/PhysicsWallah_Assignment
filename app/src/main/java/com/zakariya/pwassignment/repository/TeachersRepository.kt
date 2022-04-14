package com.zakariya.pwassignment.repository

import com.zakariya.pwassignment.api.RetrofitInstance

class TeachersRepository {
    suspend fun getTeachersData() = RetrofitInstance.api.getTeachers()
}