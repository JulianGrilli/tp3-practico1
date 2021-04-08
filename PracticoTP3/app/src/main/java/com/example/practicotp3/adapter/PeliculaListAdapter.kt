package com.example.practicotp3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicotp3.R
import com.example.practicotp3.entities.Pelicula

class PeliculaListAdapter(

        private var peliculas: MutableList<Pelicula>,
        val onItemClick: (Int) -> Boolean,
        val onRemoveItemClick: (Int) -> Boolean
) : RecyclerView.Adapter<PeliculaListAdapter.PeliculaHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaHolder {
        // Aca es donde referencio los items hijos del parent
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return (PeliculaListAdapter.PeliculaHolder(view))
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun onBindViewHolder(holder: PeliculaHolder, position: Int) {
        // Aca mi informacion que seria el nombre de la pelicula, impacta en el holder y lo muestro
        holder.setName(peliculas[position].nombre)
        holder.getCardLayout().setOnLongClickListener(){
            onItemClick(position)
        }
        
        holder.getRemoveIcon().setOnLongClickListener(){
            onRemoveItemClick(position)
        }

    }

    class PeliculaHolder(v:View) : RecyclerView.ViewHolder(v) {
        // Contiene acciones y referencias con respecto a la vista
        // Conexion entre adapter y xml del item
        private var view: View

        init {
            this.view = v
        }
        
        fun setName(name: String){
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getCardLayout ():CardView{
            // Me posiciono sobre el click especifico de la card
            return view.findViewById(R.id.card_package_item)
        }
        
        fun getRemoveIcon(): ImageView {
            return  view.findViewById(R.id.removeButton)
        }

    }

}