package com.example.artelista.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artelista.data.ICallback
import com.example.artelista.data.ServiceFirestore
import com.example.artelista.model.Notification

class NotificationsViewModel: ViewModel() {
    //Inicialización
    private val fireStoreService = ServiceFirestore()
    var listNotification: MutableLiveData<List<Notification>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun getNotificationsVM(){
        fireStoreService.getNotifications(object: ICallback<List<Notification>>{
            override fun onSuccess(result: List<Notification>?){
                listNotification.postValue(result!!)
                cargaFinalizada()
            }

            override fun onFailed(exception: Exception) {
                cargaFinalizada()
            }
        })
    }

    fun cargaFinalizada(){
        isLoading.value = true
    }
}