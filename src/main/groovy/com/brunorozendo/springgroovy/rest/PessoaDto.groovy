package com.brunorozendo.springgroovy.rest

/**
 * Dto usado para devilver ao cliente.
 */
class PessoaDto {

  String name

  PessoaDto(String name) {
    this.name = name
  }

  String getName() {
    name
  }

  void setName(String name) {
    this.name = name
  }

}
