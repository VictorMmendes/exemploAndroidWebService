package br.edu.ifpr.paranagua.tads_recyclerview.remoto

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa

class TarefaRemota(val titulo: String,
                   val corpo_da_tarefa: String,
                   val pronta: Boolean) {

    fun exportar(): Tarefa {
        return Tarefa(titulo, corpo_da_tarefa, pronta)
    }

}