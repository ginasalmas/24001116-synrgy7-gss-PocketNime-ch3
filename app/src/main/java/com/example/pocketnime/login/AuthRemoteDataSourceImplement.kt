package com.example.pocketnime.login

import kotlinx.coroutines.delay

class AuthRemoteDataSourceImplement: AuthRemoteDataSource{

    private var users = listOf(
        User(
            email = "synrgy@gmail.com",
            password = "batch7"
        )
    )
    override suspend fun login(email: String, password: String): String {
        delay(1000)
        if (users.contains(User(email, password))) {
            return "qwertyuiop1234567890"
        } else {
            throw UnsupportedOperationException("User tidak ditemukan")
        }
    }
}