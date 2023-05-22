package com.example.artelista.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artelista.data.ICallback
import com.example.artelista.data.ServiceFirestore
import com.example.artelista.model.User

class UserViewModel: ViewModel() {
    //Inicialización
    private val fireStoreService = ServiceFirestore()
    var listUser: MutableLiveData<List<User>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun getUserVM(){
        fireStoreService.getUser(object: ICallback<List<User>>{
            override fun onSuccess(result: List<User>?){
                listUser.postValue(result!!)
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