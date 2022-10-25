package com.bindu.electronicsale.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bindu.electronicsale.model.Mobile
import com.bindu.electronicsale.offlinedataprovider.MobileParsing
import com.bindu.electronicsale.offlinedataprovider.TelevisionParsing
import com.bindu.electronicsale.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MobilesActivityViewModel : ViewModel() {

    // LiveData
    val mobileList = MutableLiveData<List<Mobile>>()

    private val dataRepository = DataRepository(TelevisionParsing(), MobileParsing())

    fun getMobileList(): LiveData<List<Mobile>> {
        viewModelScope.launch {
            val mobileData = withContext(Dispatchers.IO)
            {
                dataRepository.getMobiles()
            }
            mobileList.value = mobileData
        }
        return mobileList
    }

}