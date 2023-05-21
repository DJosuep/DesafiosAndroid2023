package com.example.artelista.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artelista.data.ICallback
import com.example.artelista.data.serviceFirestore
import com.example.artelista.model.Carrito

class CarritoViewModel: ViewModel() {
    //Inicialización
    private val fireStoreService = serviceFirestore()
    var listCarrito: MutableLiveData<List<Carrito>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun getCarritoVM(){
        fireStoreService.getCarrito(object: ICallback<List<Carrito>>{
            override fun onSuccess(result: List<Carrito>?){
                listCarrito.postValue(result!!)
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