package com.example.practicotp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.practicotp3.R
import com.example.practicotp3.entities.User
import com.example.practicotp3.service.UserService
import com.google.android.material.snackbar.Snackbar


class SigninFragment : Fragment() {

    lateinit var v: View
    lateinit var btnRegistrarConfirmar: Button
    lateinit var name: EditText
    lateinit var lastName: EditText
    lateinit var userName: EditText
    lateinit var passWord: EditText
    lateinit var rePassWord: EditText
    var userService: UserService = UserService()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_signin, container, false)
        userName = v.findViewById(R.id.email_signin)
        passWord = v.findViewById(R.id.password_signin)
        btnRegistrarConfirmar = v.findViewById(R.id.btn_sign_2)
        lastName = v.findViewById(R.id.lastName)
        name = v.findViewById(R.id.name)
        rePassWord = v.findViewById(R.id.rePassword)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnRegistrarConfirmar.setOnClickListener {
            if (verificarDatosObligatorios()) {
                if (verificarPasswordIguales()) {
                    crearNuevoUsuario()
                    Snackbar.make(v,"El usuario ha sido creado", Snackbar.LENGTH_SHORT).show()
                    redirectToAction1()
                } else {
                    Snackbar.make(v,"Las password ingresadas deben ser iguales", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                Snackbar.make(v,"Faltan completar algunos datos", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    fun verificarDatosObligatorios(): Boolean {
        return userName.text.length > 0  && passWord.text.length > 0 &&
                rePassWord.text.length > 0 && name.text.length > 0 &&
                lastName .text.length > 0
    }

    fun verificarPasswordIguales(): Boolean {
        return passWord.text.toString().equals(rePassWord.text.toString())
    }

    private fun redirectToAction1(){
        val action1 = SigninFragmentDirections.actionSigninFragmentToLoginFragment()
        v.findNavController().navigate(action1)
    }

    private fun crearNuevoUsuario(){
        val user = User(userName.text.toString(), passWord.text.toString(), name.text.toString(), lastName.text.toString())
        userService.createUser(user)
    }
}