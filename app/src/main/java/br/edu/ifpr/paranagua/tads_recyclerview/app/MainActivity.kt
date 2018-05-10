package br.edu.ifpr.paranagua.tads_recyclerview.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.edu.ifpr.paranagua.tads_recyclerview.R
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Animal
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.dao.AnimalDaoRemoto
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.animais.BuscaTodosAnimaisListener
import br.edu.ifpr.paranagua.tads_recyclerview.ui.AnimaisAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BuscaTodosAnimaisListener {
    override fun onBuscaTodosAnimaisReturn(animais: List<Animal>) {
        listAnimais.adapter = AnimaisAdapter(animais)
    }

    override fun onBuscaTodosAnimaisError(mensagem: String) {
        Toast.makeText(this, "ERROR ${mensagem}", Toast.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

        listAnimais.layoutManager = layout

        carregarTarefas()

        btRegarregar.setOnClickListener {
            carregarTarefas()
        }
    }

    fun carregarTarefas() {
        var dao = AnimalDaoRemoto(this)
        dao.buscarTodos()
    }
}
