package com.brunorozendo.springgroovy

import com.brunorozendo.springgroovy.base.TestBaseSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class SpringGroovyApplicationTests extends TestBaseSpecification{

  @Autowired
  ApplicationContext context


  def "test context loads"() {
    expect:
    context != null
  }

}

