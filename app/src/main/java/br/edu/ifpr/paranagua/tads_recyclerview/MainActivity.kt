package br.edu.ifpr.paranagua.tads_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

//        val layout = GridLayoutManager(this, 2)
//        layout.orientation = GridLayoutManager.VERTICAL

//        val layout = StaggeredGridLayoutManager(2,
//                StaggeredGridLayoutManager.VERTICAL)

        listTarefas.layoutManager = layout

        carregarTarefas()

        btRegarregar.setOnClickListener({ carregarTarefas() })
    }

    fun carregarTarefas() {
        var retrofit = Retrofit.Builder()
                .baseUrl("http://10.20.23.109/tarefas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var service =
            retrofit.create(BuscaTodasTarefasService::class.java)

        var call = service.buscaTodas()

        call.enqueue(object: Callback<List<Tarefa>> {
            override fun onFailure(call: Call<List<Tarefa>>?,
                                   t: Throwable?) {

            }

            override fun onResponse(call: Call<List<Tarefa>>?,
                           response: Response<List<Tarefa>>?) {
                var tarefas:List<Tarefa> = response?.body()!!

                val adapter = TarefasAdapter(tarefas)
                listTarefas.adapter = adapter
            }

        })
    }
}
