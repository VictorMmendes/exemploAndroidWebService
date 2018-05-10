package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.animais

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Animal

/**
 * Created by aluno on 10/05/18.
 */
interface BuscaTodosAnimaisListener {
    fun onBuscaTodosAnimaisReturn(animais: List<Animal>)

    fun onBuscaTodosAnimaisError(mensagem: String)
}