package com.brunorozendo.springgroovy.rest

import com.brunorozendo.springgroovy.service.PessoaService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Endpoint que devolve pessoas usando /api/pessoa.
 */
@RestController
@RequestMapping('/api')
class PessoaRest {

  private static final Logger LOGGER = LoggerFactory.getLogger(this.getClass())

  @Autowired
  PessoaService pessoaService

  @GetMapping(path = '/pessoa/{id}', produces = 'application/json')
  PessoaDto getPessoa(@PathVariable int id) {
    LOGGER.debug('Id passado' + id)
    pessoaService.pessoa
  }

}
