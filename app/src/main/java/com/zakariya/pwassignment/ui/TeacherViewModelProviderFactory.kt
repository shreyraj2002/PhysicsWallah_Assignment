package com.zakariya.pwassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zakariya.pwassignment.repository.TeachersRepository

class TeacherViewModelProviderFactory(val teachersRepository: TeachersRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeachersViewModel(teachersRepository) as T
    }
}