package com.example.pocketnime.data.remote

interface AuthLocalDataSource {
    fun saveToken(token: String)
    fun loadToken(): String?
    fun clearToken()

}