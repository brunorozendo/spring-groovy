package com.brunorozendo.springgroovy

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Spring boot class main
 */
@SpringBootApplication(scanBasePackages = ['com.brunorozendo.springgroovy'])
class SpringGroovyApplication {

  static void main(String[] args) {
    SpringApplication.run(SpringGroovyApplication, args)
  }

}

