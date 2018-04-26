package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BuscaTarefasService {
    @GET("busca_{tipo}.php")
    fun buscaTarefas(
            @Path("tipo") tipo: String
    ): Call<List<Tarefa>>
}