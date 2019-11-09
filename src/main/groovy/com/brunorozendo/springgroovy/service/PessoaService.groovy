package com.brunorozendo.springgroovy.service

import com.brunorozendo.springgroovy.rest.PessoaDto
import org.springframework.stereotype.Service

/**
 * Classe de servico/bo o qual contém as regras de negócio referentes a essa entidade.
 */
@Service
class PessoaService {

  private final String name  = 'teste'

  PessoaDto getPessoa() {
    new PessoaDto(this.name)
  }

}
