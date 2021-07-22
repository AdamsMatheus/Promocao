package com.example.demo.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Promocao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 1,
    val descricao: String = "",
    val local: String = "",
    val isAllInclusive: Boolean = false,
    val qtdDias: Int = 1,
    val preco: Double = 0.0
    // Quando se declara um "val" a variável não varia o seu valor, uma vez atribuido ela continua com essa valor até o fim
    // o "var" é normal, como já fazemos.
)
