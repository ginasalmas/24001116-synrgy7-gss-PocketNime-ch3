package com.example.pocketnime.login

interface AuthRemoteDataSource {
    suspend fun login(email: String, password:String): String
}


