package com.kentoapps.ministagram.data.source.user

import com.kentoapps.ministagram.data.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

interface UserRepository {
    fun isSignIn(): Observable<Boolean>
    fun signUp(userName: String, email: String, password: String): Completable
    fun signIn(email: String, password: String): Completable
    fun signOut(): Completable
    fun getUser(): Observable<User>
}

class UserRepositoryImpl @Inject constructor(private val dataSource: UserDataSource) : UserRepository {
    override fun isSignIn(): Observable<Boolean> {
        return dataSource.isSignIn()
    }

    override fun signUp(userName: String, email: String, password: String): Completable {
        return dataSource.signUp(userName, email, password)
    }

    override fun signIn(email: String, password: String): Completable {
        return dataSource.signIn(email, password)
    }

    override fun signOut(): Completable {
        return dataSource.signOut()
    }

    override fun getUser(): Observable<User> {
        return dataSource.getUser()
    }
}