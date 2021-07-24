package com.example.demo.service

import com.example.demo.DemoApplication
import com.example.demo.model.Promocao
import com.example.demo.repository.PromocaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImp : PromocaoService {

    @Autowired
    lateinit var promocaoRepository: PromocaoRepository


    override fun create(promocao: Promocao) {
        this.promocaoRepository.save(promocao)
    }

    override fun getById(id: Long): Promocao? {
        return promocaoRepository.findById(id).orElseGet(null)
    }

    override fun delete(id: Long) {
        promocaoRepository.delete(Promocao(id = id))

    }

    override fun update(id: Long, promocao: Promocao) {
        return
    }

    override fun searchByLocal(local: String): List<Promocao> {
        TODO("Not yet implemented")
    }

    override fun getAll(start: Int, size: Int): List<Promocao> {
        val pages:Pageable = PageRequest.of(start,size)
        return this.promocaoRepository.findAll(pages).toList()
    }
}

