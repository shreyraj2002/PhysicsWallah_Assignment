package com.zakariya.pwassignment.ui

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zakariya.pwassignment.model.Teacher
import com.zakariya.pwassignment.repository.TeachersRepository
import com.zakariya.pwassignment.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class TeachersViewModel(val repository: TeachersRepository) : ViewModel() {
    val teachersData: MutableLiveData<Resource<List<Teacher>>> = MutableLiveData()

    init {
        getTeachersData()
    }

    fun getTeachersData() = viewModelScope.launch {
        teachersData.postValue(Resource.Loading())
        val response = repository.getTeachersData()
        teachersData.postValue(handleTeacherResponse(response))

    }

    private fun handleTeacherResponse(response: Response<List<Teacher>>): Resource<List<Teacher>> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}