package com.example.e_commerce_mvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce_mvvm.Domain.BannerModel
import com.example.e_commerce_mvvm.Domain.CategoryModel
import com.example.e_commerce_mvvm.Domain.ItemsModel
import com.example.e_commerce_mvvm.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>> {
        return repository.loadPopular()
    }
}