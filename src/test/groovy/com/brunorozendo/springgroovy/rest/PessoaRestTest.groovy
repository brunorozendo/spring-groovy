package com.brunorozendo.springgroovy.rest

import com.brunorozendo.springgroovy.base.TestBaseSpecification
import com.brunorozendo.springgroovy.service.PessoaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.hamcrest.Matchers.hasSize
import static org.hamcrest.Matchers.is
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class PessoaRestTest extends TestBaseSpecification{


  @Autowired
  @Qualifier("pessoaService")
  PessoaService pessoaService

  @Autowired
  PessoaRest pessoaRest

  def mockMvc = MockMvcBuilders.standaloneSetup().build()


  void setup() {
    pessoaRest.pessoaService = pessoaService
  }

  def 'pesquisar por unidade chama o serviço e retorna como JSON'() {
    given:
    pessoaService.pessoa >> {
      def pessoaDto = new PessoaDto()
      pessoaDto.name = "jajajaa"
      return pessoaDto
    }


    when:
    def response = mockMvc.perform(get("/api/pessoa/10"))

    then:
    response.andExpect(status().isOk())
    response.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    response.andExpect(jsonPath('$', hasSize(1)))
    response.andExpect(jsonPath('$[0].nome', is('jajajaa')))

  }

}
