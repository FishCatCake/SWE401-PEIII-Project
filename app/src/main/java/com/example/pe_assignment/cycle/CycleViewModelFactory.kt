package com.example.pe_assignment.cycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.database.repository.CycleRepository
import java.lang.IllegalArgumentException

class CycleViewModelFactory(private val repository: CycleRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CycleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CycleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}