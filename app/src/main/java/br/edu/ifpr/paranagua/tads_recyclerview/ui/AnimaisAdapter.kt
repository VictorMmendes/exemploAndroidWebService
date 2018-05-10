package br.edu.ifpr.paranagua.tads_recyclerview.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifpr.paranagua.tads_recyclerview.R
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Animal
import kotlinx.android.synthetic.main.animal_item.view.*
import java.text.SimpleDateFormat

class AnimaisAdapter(val animais: List<Animal>) :
        RecyclerView.Adapter<AnimaisAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup?, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.animal_item,
                        parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = animais.size

    override fun onBindViewHolder(
            holder: ViewHolder?, position: Int) {
        val animal = animais[position]
        holder?.let {
            it.preencherView(animal)
        }
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {

        fun preencherView(animal: Animal) {
            val f = SimpleDateFormat("dd/mm/yyyy")

            itemView.txtNome.text = animal.nome
            itemView.txtEspecie.text = animal.especie
            itemView.txtRaca.text = animal.raca
            itemView.txtPorte.text = animal.porte.toString()
            itemView.txtNascimento.text = f.format(animal.nascimento)
            itemView.txtPeso.text = animal.peso.toString()
        }
    }
}