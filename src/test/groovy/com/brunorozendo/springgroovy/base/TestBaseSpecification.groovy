package com.brunorozendo.springgroovy.base

import com.brunorozendo.springgroovy.base.config.TestBaseConfiguration
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringBootContextLoader, classes = TestBaseConfiguration)
class TestBaseSpecification extends Specification{

}
