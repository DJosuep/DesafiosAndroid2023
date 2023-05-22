package com.example.artelista.data

import com.example.artelista.model.Carrito
import com.example.artelista.model.Notification
import com.example.artelista.model.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

//Nombre de las colecciones tal cual existen en Firebase
const val CARRITO_COLLECTION_NAME="Carrito"
const val NOTIFICATION_COLLECTION_NAME="Notification"
const val USER_COLLECTION_NAME="User"

class ServiceFirestore  {
    //------------------
    private val CloudFirestore = FirebaseFirestore.getInstance()
    private val settings = FirebaseFirestoreSettings.Builder().build()

    init{
        //Nos permite tener los datos offline
        CloudFirestore.firestoreSettings = settings

    }
    fun getCarrito(callback: ICallback<List<Carrito>>) {
        CloudFirestore.collection(CARRITO_COLLECTION_NAME)
            .orderBy("artistaCarrito")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(Carrito::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getNotifications(callback: ICallback<List<Notification>>) {
        CloudFirestore.collection(USER_COLLECTION_NAME)
            .orderBy("tituloNotification")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(Notification::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getUser(callback: ICallback<List<User>>) {
        CloudFirestore.collection(NOTIFICATION_COLLECTION_NAME)
            .orderBy("nombreUsuario")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result) {
                    val list=result.toObjects(User::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}