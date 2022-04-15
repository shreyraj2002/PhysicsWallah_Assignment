package com.zakariya.pwassignment.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zakariya.pwassignment.PWApplication
import com.zakariya.pwassignment.model.Teacher
import com.zakariya.pwassignment.repository.TeachersRepository
import com.zakariya.pwassignment.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class TeachersViewModel(app: Application, val repository: TeachersRepository) : AndroidViewModel(app) {
    val teachersData: MutableLiveData<Resource<List<Teacher>>> = MutableLiveData()

    init {
        getTeachersData()
    }

    fun getTeachersData() = viewModelScope.launch {
        teachersData.postValue(Resource.Loading())

        try {
            if (hasInternetConnection()){
                val response = repository.getTeachersData()
                teachersData.postValue(handleTeacherResponse(response))
            } else {
                teachersData.postValue(Resource.Error("No Internet Connection"))
            }
        } catch (e: Exception) {

            teachersData.postValue(Resource.Error(e.message.toString()))
        }

    }

    private fun handleTeacherResponse(response: Response<List<Teacher>>): Resource<List<Teacher>> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun hasInternetConnection():Boolean{
        val connectivityManager = getApplication<PWApplication>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capability = connectivityManager.getNetworkCapabilities(activeNetwork)?: return false
        return when {
            capability.hasTransport(TRANSPORT_WIFI) -> true
            capability.hasTransport(TRANSPORT_CELLULAR) -> true
            capability.hasTransport(TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}