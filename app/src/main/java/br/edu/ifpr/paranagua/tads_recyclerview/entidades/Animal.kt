package br.edu.ifpr.paranagua.tads_recyclerview.entidades

import java.util.*

/**
 * Created by aluno on 10/05/18.
 */
data class Animal(var id: Int,
                  var nome: String,
                  var especie: String,
                  var raca: String,
                  var peso: Float,
                  var nascimento: Date,
                  var porte: Tamanho){
    enum class Tamanho
    {
        P, M, G
    }

}