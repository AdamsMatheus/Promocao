package com.example.demo.service

import com.example.demo.DemoApplication
import com.example.demo.model.Promocao
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap


class PromocaoServiceImp : PromocaoService {

    companion object {
        //Quando iniciada aplicação, sobe as promoções
        val initialPromocoes = arrayOf(
            Promocao(1, "Maravilhosa viagem", "Cancun", true, 7, 4000.00),
            Promocao(2, "Maravilhosa viagem", "Belgica", true, 7, 4000.00),
            Promocao(3, "Maravilhosa viagem", "India", true, 7, 4000.00),
            Promocao(4, "Maravilhosa viagem", "Nova Iorque", true, 7, 4000.00)
        )
    }

    var promocoes =
        ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))


    override fun create(promocao: Promocao) {
        promocoes[promocao.id]= promocao
    }

    override fun getById(id: Long): Promocao? {
        return promocoes[id]
    }

    override fun delete(id: Long) {
        promocoes.remove(id)

    }

    override fun update(id: Long, promocao: Promocao) {
        delete(id)
        create(promocao)
    }

    override fun searchByLocal(local: String): List<Promocao> =
        promocoes.filter { it.value.local.contains(local, true) }.map(Map.Entry<Long, Promocao>::value).toList()
}