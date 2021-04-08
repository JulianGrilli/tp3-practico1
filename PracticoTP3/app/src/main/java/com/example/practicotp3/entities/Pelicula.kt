package com.example.practicotp3.entities

import android.os.Parcel
import android.os.Parcelable

class Pelicula(nombre: String, descripcion: String, anio: Int, genero: String): Parcelable {

    var nombre: String
    var descripcion: String
    var anio: Int
    var genero: String

    init {
        this.nombre = nombre
        this.descripcion = descripcion
        this.anio = anio
        this.genero = genero
    }

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt()!!,
            parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeInt(anio)
        parcel.writeString(genero)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pelicula> {
        override fun createFromParcel(parcel: Parcel): Pelicula {
            return Pelicula(parcel)
        }

        override fun newArray(size: Int): Array<Pelicula?> {
            return arrayOfNulls(size)
        }
    }
}