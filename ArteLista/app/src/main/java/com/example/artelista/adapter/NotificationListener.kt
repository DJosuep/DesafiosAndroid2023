package com.example.artelista.adapter

import com.example.artelista.model.Notification

interface NotificationListener {
    fun onNotificationClicked(Notification: Notification, position: Int)
}