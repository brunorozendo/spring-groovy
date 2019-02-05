package com.brunorozendo.springgroovy.rest

import com.brunorozendo.springgroovy.service.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PessoaRest{

  @Autowired
  PessoaService pessoaService

  @GetMapping(path = "/pessoa/{id}", produces = "application/json")
  PessoaDto getPessoa(@PathVariable int id) {
    return pessoaService.getPessoa()
  }

}
