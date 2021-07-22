package com.example.demo.repository

import com.example.demo.model.Promocao
import org.springframework.data.jpa.repository.JpaRepository

interface PromocaoRepository: JpaRepository<Promocao,Long>{

}