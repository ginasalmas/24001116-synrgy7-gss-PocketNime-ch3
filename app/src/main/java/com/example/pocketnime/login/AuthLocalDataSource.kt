package com.example.pocketnime.login

interface AuthLocalDataSource {
    fun saveToken(token: String)
    fun loadToken(): String?
    fun clearToken()

}