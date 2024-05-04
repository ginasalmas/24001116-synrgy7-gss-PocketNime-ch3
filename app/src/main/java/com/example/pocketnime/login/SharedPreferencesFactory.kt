package com.example.pocketnime.login

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesFactory {

    companion object{
        const val SHARED_PREFERENCES_Name = "shared_preferences"
    }

    fun createSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_Name, Context.MODE_PRIVATE)
    }
}
