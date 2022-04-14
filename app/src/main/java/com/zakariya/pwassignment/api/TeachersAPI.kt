package com.zakariya.pwassignment.api

import com.zakariya.pwassignment.modal.Teacher
import retrofit2.Response
import retrofit2.http.GET

interface TeachersAPI {

    @GET("easygautam/data/users")
    suspend fun getTeachers():Response<Teacher>
}