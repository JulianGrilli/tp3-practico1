package com.example.practicotp3.repository

import com.example.practicotp3.entities.Pelicula

object PeliculaRepository {

    var listaPeliculas: MutableList<Pelicula> = mutableListOf(
            Pelicula("El Hobbit", "Pelicula del Hobbit, precuela del señor de los anillos", 2012, "Fantasia"),
            Pelicula("Capitan America", "Pelicula del Capitan America de Marvel", 2018, "Ciencia Ficcion"),
            Pelicula("Harry Potter", "Pelicula del HP, la primera de la saga", 2003, "Ciencia Ficcion"),
            Pelicula("El Conjuro", "Pelicula del Conjuro, hecho real sucedido el siglo anterior", 2006, "Terror"),
            Pelicula("El Rey Leon", "Pelicula animada de disney, simba y timon y pumba", 2006, "Infantil"),
            Pelicula("Iron Man", "Pelicula del Hombre de Hierro de marvel", 2006, "Ciencia Ficcion"),
            Pelicula("El Conjuro 2", "Pelicula del Conjuro 2, hecho real sucedido el siglo anterior, segunda saga", 2006, "Terror"),
            Pelicula("Tonto y re Tonto", "Pelicula del Jim Carrey, una comedia de locos!!", 2007, "Comedia")
    )

    fun findAll(): MutableList<Pelicula> {
        return listaPeliculas
    }

    fun findByPosition(position: Int): Pelicula {
        return listaPeliculas.get(position)
    }

    fun removeByPosition(position: Int){
        val pelicula = listaPeliculas.get(position)
        listaPeliculas.remove(pelicula)
    }

    fun save(pelicula: Pelicula){
        listaPeliculas.add(pelicula)
    }
}