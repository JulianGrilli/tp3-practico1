package com.example.practicotp3.service

import android.content.res.Resources
import com.example.practicotp3.entities.User
import com.example.practicotp3.repository.UserRepository

class UserService {

    var userRepository: UserRepository = UserRepository

    fun findUserByUsernameAndPassword(email: String, password: String): User {
        try {
            val usuarioFiltrado = userRepository.findByUsernameAndPassword(email, password)
            return usuarioFiltrado
        } catch (e: Resources.NotFoundException) {
            System.out.println(" === ERROR :" + e.message.toString())
            throw e

        }

    }

    fun createUser(user: User){
        userRepository.save(user)
    }
}