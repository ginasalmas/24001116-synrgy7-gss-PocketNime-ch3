package com.example.pocketnime.login

class AuthRepositoryImplement (
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource,
): AuthRepository {
    override suspend fun login(email: String, password: String): String {
        return authRemoteDataSource.login(email, password)
    }

    override fun saveToken(token: String) {
        authLocalDataSource.saveToken(token)
    }

    override fun loadToken(): String? {
        return authLocalDataSource.loadToken()
    }

    override fun clearToken() {
        authLocalDataSource.clearToken()
    }
}