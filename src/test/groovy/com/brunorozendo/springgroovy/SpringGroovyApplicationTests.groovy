package com.brunorozendo.springgroovy

import com.brunorozendo.springgroovy.base.TestBaseSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class SpringGroovyApplicationTests extends TestBaseSpecification{

  @Autowired
  ApplicationContext context

  def "test context loads"() {
    expect: "valida se o objeto foi criar,"
    and: "significa que o spring consegui rodar sem nehum  problema."
    context != null
  }

}

