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
import com.example.practicotp3.entities.Pelicula
import com.example.practicotp3.service.PeliculaService

class NewPeliculaFragment : Fragment() {

    lateinit var v: View
    lateinit var nombreTxt: EditText
    lateinit var descTxt: EditText
    lateinit var generoTxt: EditText
    lateinit var anioTxt: EditText
    lateinit var addBtn: Button;
    var peliculaService: PeliculaService = PeliculaService()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_new_pelicula, container, false)
        nombreTxt = v.findViewById(R.id.nombre)
        descTxt = v.findViewById(R.id.desc_pelicula)
        generoTxt = v.findViewById(R.id.peli_genero)
        anioTxt = v.findViewById(R.id.peli_anio)
        addBtn = v.findViewById(R.id.add_peli_btn)
        return v
    }

    override fun onStart() {
        super.onStart()

        addBtn.setOnClickListener {
            val pelicula = Pelicula(nombreTxt.text.toString(), descTxt.text.toString(), 2020, generoTxt.text.toString())
            peliculaService.save(pelicula)
            val action = NewPeliculaFragmentDirections.actionNewPeliculaFragmentToPeliculaFragment()
            v.findNavController().navigate(action)
        }
    }

}