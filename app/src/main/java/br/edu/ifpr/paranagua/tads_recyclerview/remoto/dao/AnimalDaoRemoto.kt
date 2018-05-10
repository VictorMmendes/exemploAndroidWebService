package br.edu.ifpr.paranagua.tads_recyclerview.remoto.dao

import br.edu.ifpr.paranagua.tads_recyclerview.remoto.Entidades.AnimalRemoto
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.animais.BuscaTodosAnimaisListener
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.animais.AnimaisService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by diego on 26/04/18.
 */
class AnimalDaoRemoto(val listener: BuscaTodosAnimaisListener) {

    private var retrofit = Retrofit.Builder()
            .baseUrl("http://10.20.23.189:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun buscarTodos() {
        var service =
                retrofit.create(AnimaisService::class.java)

        var call = service.buscaTodos()

        call.enqueue(object: Callback<List<AnimalRemoto>> {
            override fun onFailure(call: Call<List<AnimalRemoto>>?, t: Throwable?) {
                listener.onBuscaTodosAnimaisError("Deu ruim")
            }

            override fun onResponse(call: Call<List<AnimalRemoto>>?,
                                    response: Response<List<AnimalRemoto>>?) {
                var animaisRemotos:List<AnimalRemoto> = response?.body()!!
                var animais = animaisRemotos.map { animalRemoto -> animalRemoto.toAnimal() }

                listener.onBuscaTodosAnimaisReturn(animais)
            }

        })
    }
}