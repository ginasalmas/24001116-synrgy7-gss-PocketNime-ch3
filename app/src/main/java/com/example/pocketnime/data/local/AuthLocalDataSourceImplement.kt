package com.example.pocketnime.data.local

import android.content.SharedPreferences
import com.example.pocketnime.data.remote.AuthLocalDataSource

class AuthLocalDataSourceImplement (
    private val sharedPreferences: SharedPreferences
) : AuthLocalDataSource {

    companion object {
        const val KEY_TOKEN = "token"
    }
    override fun saveToken(token: String) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
    }

    override fun loadToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

    override fun clearToken() {
        sharedPreferences.edit().remove(KEY_TOKEN).apply()
    }
}