package br.edu.ifpr.paranagua.tads_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todasTarefasdoMundo =
                listOf<Tarefa>(
                        Tarefa("Lavar o gato", "Com sabão de soda!"),
                        Tarefa("Catar folhas", "Jardim"),
                        Tarefa("Fazer trabalho de DM", "Sério!"),
                        Tarefa("Lavar o gato", "a\nb\ng\nf\nr\nt\nj\n\nCo\nm \nsa\n\n\nb\não de soda!"),
                        Tarefa("Catar folhas", "Jardim"),
                        Tarefa("Fazer trabalho de DM", "Sério!"),
                        Tarefa("Lavar o gato", "Com \nsabão de \nsoda!"),
                        Tarefa("Catar folhas", "Jardim"),
                        Tarefa("Fazer trabalho de DM", "Sério!"),
                        Tarefa("Lavar o gato", "Com sabão de soda!"),
                        Tarefa("Catar folhas", "Jar\nd\nim"),
                        Tarefa("Fazer trabalho de DM", "Sério!"),
                        Tarefa("Lavar o gato", "Com sabão de soda!"),
                        Tarefa("Catar folhas", "Jar\ndim"),
                        Tarefa("Fazer trabalho de DM", "Sério!"),
                        Tarefa("Não sei mais o que", "")
                )

        val adapter = TarefasAdapter(todasTarefasdoMundo)
        listTarefas.adapter = adapter

//        val layout = LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL, false)

//        val layout = GridLayoutManager(this, 2)
//        layout.orientation = GridLayoutManager.VERTICAL

        val layout = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)

        listTarefas.layoutManager = layout
    }
}
