package com.bindu.electronicsale.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bindu.electronicsale.api.RetrofitBuilder
import com.bindu.electronicsale.model.Television
import com.bindu.electronicsale.source.DataRepository
import com.bindu.electronicsale.source.ManualParsing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    // LiveData
    private val television = MutableLiveData<Television>()
    val televisionList = MutableLiveData<List<Television>>()

    private val dataRepository = DataRepository(ManualParsing())
    //private val dataRepository = DataRepository(RetrofitBuilder.getService())

    fun getTelevision(): LiveData<Television> {
        viewModelScope.launch{
            val televisionData = withContext(Dispatchers.IO) {
                dataRepository.getTelevision()
            }
            television.value = televisionData
        }
        return television
    }


    fun getTelevisionList(): LiveData<List<Television>>{
        viewModelScope.launch{
            val movieData = withContext(Dispatchers.IO)
            {
                dataRepository.getTelevisions()
            }
            televisionList.value = movieData
        }
        return televisionList
    }

}