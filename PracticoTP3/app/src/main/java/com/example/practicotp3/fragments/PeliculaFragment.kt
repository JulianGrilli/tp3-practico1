package com.example.practicotp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicotp3.R
import com.example.practicotp3.adapter.PeliculaListAdapter
import com.example.practicotp3.entities.Pelicula
import com.example.practicotp3.service.PeliculaService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class PeliculaFragment : Fragment() {

    lateinit var v: View
    lateinit var addButton: FloatingActionButton
    lateinit var recPeliculas: RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var peliculaListAdapter: PeliculaListAdapter
    var peliculas : MutableList<Pelicula> = ArrayList<Pelicula>()
    var peliculaService: PeliculaService = PeliculaService()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v=  inflater.inflate(R.layout.fragment_pelicula, container, false)
        recPeliculas = v.findViewById(R.id.recPeliculas)
        addButton = v.findViewById(R.id.addButton)
        return v
    }

    override fun onStart() {
        super.onStart()
        peliculas = peliculaService.findAll() // Trae todas las pelis y las carga

        // Layout configuration
        recPeliculas.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recPeliculas.layoutManager = linearLayoutManager

        // La funcion que le paso es lo que hara en cada click para cada posicion
        // Aca podriamnos ir a buscar byId o algo asi
        peliculaListAdapter = PeliculaListAdapter(peliculas, {x -> onItemClick(x)}, {x -> onRemoveItemClick(x)})
        recPeliculas.adapter = peliculaListAdapter

        addButton.setOnClickListener {
          Snackbar.make(v,"Adding new", Snackbar.LENGTH_SHORT).show()
        }
    }

    fun onItemClick (position: Int): Boolean {
        val pelicula = peliculaService.findByPosition(position)
        Snackbar.make(v, pelicula.descripcion, Snackbar.LENGTH_SHORT).show()
        redirectToPeliculaDetalleFragment(pelicula)
        return true
    }

    fun onRemoveItemClick(position: Int): Boolean{
        peliculaService.removeByPosition(position)
        peliculaListAdapter.notifyDataSetChanged() // Clave para refrescar los datos en la pantalla
        return true
    }

    private fun redirectToPeliculaDetalleFragment(pelicula: Pelicula) {
        val action = PeliculaFragmentDirections.actionPeliculaFragmentToPeliculaDetalleFragment(pelicula)
        v.findNavController().navigate(action)
    }
}