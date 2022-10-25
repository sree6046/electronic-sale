package com.bindu.electronicsale.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bindu.electronicsale.model.Television
import com.bindu.electronicsale.offlinedataprovider.MobileParsing
import com.bindu.electronicsale.offlinedataprovider.TelevisionParsing
import com.bindu.electronicsale.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TelevisionsActivityViewModel : ViewModel() {

    // LiveData
    private val television = MutableLiveData<Television>()
    val televisionList = MutableLiveData<List<Television>>()
    private val dataRepository = DataRepository(TelevisionParsing(), MobileParsing())

    fun getTelevision(): LiveData<Television> {
        viewModelScope.launch {
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