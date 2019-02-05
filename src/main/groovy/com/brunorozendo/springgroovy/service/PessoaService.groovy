package com.brunorozendo.springgroovy.service

import com.brunorozendo.springgroovy.rest.PessoaDto
import org.springframework.stereotype.Service

@Service
class PessoaService{

  PessoaDto getPessoa() {
    PessoaDto p = new PessoaDto()
    p.name = 'bruno'
    return p
  }


}
