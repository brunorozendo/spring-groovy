package com.brunorozendo.springgroovy.base.config

import com.brunorozendo.springgroovy.SpringGroovyApplication
import com.brunorozendo.springgroovy.service.PessoaService
import org.spockframework.spring.ScanScopedBeans
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.mock.DetachedMockFactory

@SpringBootTest
@ContextConfiguration(classes = [SpringGroovyApplication])
@TestConfiguration
@ScanScopedBeans
@ComponentScan(basePackages = ['com.brunorozendo.springgroovy'])
@TestPropertySource(locations = [
    'classpath:/config/application.yaml',
    'classpath:/config/application-test.yaml'])
class TestBaseConfiguration{

  DetachedMockFactory mockFactory = new DetachedMockFactory()

  @Bean(name = "pessoaServiceTest")
  PessoaService pessoaService() {
    return mockFactory.Mock(PessoaService)
  }

}
