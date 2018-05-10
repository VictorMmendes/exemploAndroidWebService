package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.animais

import br.edu.ifpr.paranagua.tads_recyclerview.remoto.Entidades.AnimalRemoto
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by aluno on 10/05/18.
 */
interface AnimaisService {
    @GET("animals.json")
    fun buscaTodos(): Call<List<AnimalRemoto>>
}