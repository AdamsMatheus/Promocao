package com.example.demo.repository

import com.example.demo.model.Promocao
import org.springframework.data.repository.PagingAndSortingRepository

interface PromocaoRepository: PagingAndSortingRepository<Promocao,Long>{

}