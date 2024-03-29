package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa
import retrofit2.Call
import retrofit2.http.GET

interface BuscaTodasTarefasService {
    @GET("busca_todas.php")
    fun buscaTodas(): Call<List<Tarefa>>
}