package com.brunorozendo.springgroovy.base

import com.brunorozendo.springgroovy.base.config.TestBaseConfiguration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = TestBaseConfiguration)
class TestBaseSpecification extends Specification{

}
