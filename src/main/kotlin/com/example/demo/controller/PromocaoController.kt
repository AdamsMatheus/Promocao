package com.example.demo.controller

import com.example.demo.model.Promocao
import com.example.demo.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/promocoes")
class PromocaoController {
    @Autowired //Notação que instacia o objeto.
    lateinit var promocaoService: PromocaoService

    @GetMapping(value = ["/{id}"])
    fun getById(@PathVariable id: Long): ResponseEntity<Promocao?> { //A notação PathVariable vc utiliza quando quer passar uma variável por parametro de chamada no endpoint
        var promocao = this.promocaoService.getById(id)
        var status = if (promocao == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(promocao, status)
    }

    @PostMapping
    fun create(@RequestBody promocao: Promocao): ResponseEntity<Unit> {
        this.promocaoService.create(promocao)
        return ResponseEntity(Unit, HttpStatus.CREATED)
        //A notação @RequestBody serve para identificar que o json passado no endPoint é do tipo promoção
    }

    @DeleteMapping(value = ["{id}"])
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (this.getById(id) != null) {
            this.promocaoService.delete(id)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (this.getById(id) != null) {
            this.promocaoService.update(id, promocao)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)

    }

    @GetMapping()
    fun getAll(@RequestParam(required = false,defaultValue = "1")start: Int,
               @RequestParam( required = false, defaultValue = "3") size: Int)
                :ResponseEntity<List<Promocao>>{
        val response = this.promocaoService.getAll(start,size)
        val status = if(response.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(response,status)
    }

}