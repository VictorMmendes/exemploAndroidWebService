package br.edu.ifpr.paranagua.tads_recyclerview.remoto.dao

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.BuscaTarefasService
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.BuscaTodasTarefasService
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.InserirTarefaService
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.TarefaRemotaListener
import br.edu.ifpr.paranagua.tads_recyclerview.ui.TarefasAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by diego on 26/04/18.
 */
class TarefaDaoRemoto(val listener: TarefaRemotaListener) {

    enum class TipoBusca {
        TODAS,
        PRONTAS
    }

    private var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2/tarefas/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun buscarTodas() {
        var service =
                retrofit.create(BuscaTodasTarefasService::class.java)

        var call = service.buscaTodas()

        call.enqueue(object: Callback<List<Tarefa>> {
            override fun onFailure(call: Call<List<Tarefa>>?,
                                   t: Throwable?) {
                listener.onTarefaError("Deu Ruim!")
            }

            override fun onResponse(call: Call<List<Tarefa>>?,
                                    response: Response<List<Tarefa>>?) {
                var tarefas:List<Tarefa> = response?.body()!!

                listener.onBuscaTodasReturn(tarefas)
            }

        })
    }

    fun buscarTarefas(tipo: TipoBusca) {
        var service =
                retrofit.create(BuscaTarefasService::class.java)

        var call = service.buscaTarefas(tipo.toString().toLowerCase())

        call.enqueue(object: Callback<List<Tarefa>> {
            override fun onFailure(call: Call<List<Tarefa>>?,
                                   t: Throwable?) {
                listener.onTarefaError("Deu Ruim!")
            }

            override fun onResponse(call: Call<List<Tarefa>>?,
                                    response: Response<List<Tarefa>>?) {
                var tarefas:List<Tarefa> = response?.body()!!

                listener.onBuscaTarefasReturn(tarefas)
            }

        })
    }

    fun inserir(tarefa: Tarefa) {
        var service =
                retrofit.create(InserirTarefaService::class.java)

        var call = service.inserir(
                tarefa.titulo,
                tarefa.descricao,
                if (tarefa.pronta) 1 else 0
        )

        call.enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>?,
                                   t: Throwable?) {
                listener.onTarefaError("Deu Ruim!")
            }

            override fun onResponse(call: Call<String>?,
                                    response: Response<String>?) {
            }

        })
    }

}