package br.edu.ifpr.paranagua.tads_recyclerview

import retrofit2.Call
import retrofit2.http.GET

interface BuscaTodasTarefasService {
    @GET("busca_todas.php")
    fun buscaTodas(): Call<List<Tarefa>>
}