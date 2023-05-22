package com.example.artelista.adapter

import com.example.artelista.model.User

interface UserListener {
    fun onUserClicked(User: User, position: Int)
}