package com.zakariya.pwassignment.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zakariya.pwassignment.model.Teacher
import com.zakariya.pwassignment.repository.TeachersRepository
import kotlinx.coroutines.launch

class TeachersViewModel(val repository: TeachersRepository): ViewModel() {
    val teachersData:MutableLiveData<List<Teacher>> = MutableLiveData()

    init {
        getTeachersData()
    }

    fun getTeachersData() = viewModelScope.launch {
        val response = repository.getTeachersData()
        teachersData.postValue(response.body())
    }
}