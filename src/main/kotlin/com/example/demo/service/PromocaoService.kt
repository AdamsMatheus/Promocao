package com.example.demo.service

import com.example.demo.model.Promocao
import org.springframework.stereotype.Service


interface PromocaoService{
    fun create (promocao: Promocao)
    fun getById(id: Long): Promocao?
    fun delete(id:Long)
    fun update(id:Long, promocao: Promocao)
    fun searchByLocal(local:String): List<Promocao>
    fun getAll(start: Int, size: Int) : List<Promocao>

}