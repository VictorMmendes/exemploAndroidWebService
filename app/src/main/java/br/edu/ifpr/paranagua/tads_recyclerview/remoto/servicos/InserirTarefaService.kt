package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface InserirTarefaService {
    @POST("inserir.php")
    fun inserir(
            @Query("titulo") titulo: String,
            @Query("descricao") descricao: String,
            @Query("pronta") pronta: Int
    ): Call<String>
}