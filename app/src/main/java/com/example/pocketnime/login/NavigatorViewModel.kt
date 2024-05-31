package com.example.pocketnime.login

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.pocketnime.domain.AuthRepository
import com.example.pocketnime.data.local.AuthLocalDataSourceImplement
import com.example.pocketnime.data.local.SharedPreferencesFactory
import com.example.pocketnime.data.remote.AuthRemoteDataSourceImplement
import com.example.pocketnime.repository.AuthRepositoryImplement

class NavigatorViewModel (
    private val authRepository: AuthRepository
) : ViewModel() {

    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context,
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle,
                ): T {
                    val authRepository: AuthRepository = AuthRepositoryImplement(
                        authLocalDataSource = AuthLocalDataSourceImplement(
                            sharedPreferences = SharedPreferencesFactory().createSharedPreferences(context),
                        ),
                        authRemoteDataSource = AuthRemoteDataSourceImplement(),
                    )
                    return NavigatorViewModel(authRepository = authRepository) as T
                }
            }
    }

    fun checkLogin(): Boolean {
        return !authRepository.loadToken().isNullOrEmpty()
    }
}
