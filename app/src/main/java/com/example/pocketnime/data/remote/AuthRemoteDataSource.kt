package com.example.pocketnime.data.remote

interface AuthRemoteDataSource {
    suspend fun login(email: String, password:String): String
}


