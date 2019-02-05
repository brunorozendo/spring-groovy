package com.brunorozendo.springgroovy.base.config

import com.brunorozendo.springgroovy.service.PessoaService
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import spock.mock.DetachedMockFactory

@TestConfiguration
@ComponentScan(basePackages = ['com.brunorozendo.springgroovy'])
class TestBaseConfiguration{

  DetachedMockFactory mockFactory = new DetachedMockFactory()

  @Bean
  PessoaService pessoaServiceTest() {
    return mockFactory.Mock(PessoaService)
  }

}
