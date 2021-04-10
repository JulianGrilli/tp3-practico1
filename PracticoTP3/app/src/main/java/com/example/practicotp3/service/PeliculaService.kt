package com.example.practicotp3.service

import com.example.practicotp3.entities.Pelicula
import com.example.practicotp3.repository.PeliculaRepository

class PeliculaService {

    var peliculaRepository: PeliculaRepository = PeliculaRepository

    fun findAll(): MutableList<Pelicula>{
        return peliculaRepository.findAll()
    }

    fun findByPosition(position: Int): Pelicula{
        return peliculaRepository.findByPosition(position)
    }

    fun removeByPosition(position: Int){
        peliculaRepository.removeByPosition(position)
    }

    fun save(pelicula: Pelicula){
        peliculaRepository.save(pelicula)
    }
}