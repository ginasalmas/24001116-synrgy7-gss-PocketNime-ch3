package com.example.pocketnime.login

interface AuthRepository {

    suspend fun login(email: String, password: String): String
    fun saveToken(token: String)
    fun loadToken(): String?
    fun clearToken()

}