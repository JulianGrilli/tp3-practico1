package com.example.practicotp3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.practicotp3.R
import com.example.practicotp3.entities.Pelicula
import com.google.android.material.snackbar.Snackbar

class PeliculaDetalleFragment : Fragment() {

    lateinit var v: View
    lateinit var pelicula: Pelicula
    lateinit var nombre: TextView
    lateinit var descripcion: TextView
    lateinit var anio: TextView
    lateinit var genero: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_pelicula_detalle, container, false)
        nombre = v.findViewById(R.id.tituloNombre)
        descripcion = v.findViewById(R.id.descripcion)
        anio = v.findViewById(R.id.anio)
        genero = v.findViewById(R.id.genero)
        return v
    }

    override fun onStart() {
        super.onStart()
        pelicula = PeliculaDetalleFragmentArgs.fromBundle(requireArguments()).pelicula
        var message = "Pelicula: " + pelicula.nombre
        Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show()
        nombre.text = pelicula.nombre.toString()
        descripcion.text = pelicula.descripcion.toString()
        anio.text = pelicula.anio.toString()
        genero.text = pelicula.genero.toString()
    }
}