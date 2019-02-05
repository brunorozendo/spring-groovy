package com.brunorozendo.springgroovy.rest

import com.brunorozendo.springgroovy.base.TestBaseSpecification
import com.brunorozendo.springgroovy.service.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.hamcrest.Matchers.is
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class PessoaRestTest extends TestBaseSpecification {


    @Autowired
    PessoaService pessoaServiceTest

    @Autowired
    PessoaRest pessoaRest

    MockMvc mockMvc


    void setup() {
        this.pessoaRest.pessoaService = pessoaServiceTest
        this.mockMvc = MockMvcBuilders.standaloneSetup(pessoaRest).build()
    }

    def 'pesquisar por unidade chama o serviço e retorna como JSON'() {
        given:
        1 * pessoaServiceTest.pessoa >> {
            def pessoaDto = new PessoaDto()
            pessoaDto.name = "jajajaa"
            return pessoaDto
        }


        when:
        def response = mockMvc.perform(get("/api/pessoa/10"))

        then:
        response.andExpect(status().isOk())
        response.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        response.andExpect(jsonPath('$.name', is('jajajaa')))

    }

}
