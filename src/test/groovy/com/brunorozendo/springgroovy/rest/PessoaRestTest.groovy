package com.brunorozendo.springgroovy.rest

import com.brunorozendo.springgroovy.service.PessoaService
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

import static org.hamcrest.Matchers.is
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@Title("This is easy to read")
@Narrative("""
As a user
I want foo
So that bar
""")
class PessoaRestTest extends Specification{

  PessoaService pessoaService
  PessoaRest pessoaRest
  MockMvc mockMvc

  def setupSpec() {
    reportHeader "<h2>Algum nome relevante</h2>"
  }

  void setup() {
    this.pessoaService = Mock(PessoaService)
    this.pessoaRest = new PessoaRest(pessoaService)
    this.mockMvc = MockMvcBuilders.standaloneSetup(pessoaRest).build()
  }

  def 'pesquisar por unidade chama o serviço e retorna como JSON'() {
    reportInfo "Some information I want to show in the report"
    given: "mock do retorno na pessoa"
    1 * this.pessoaService.pessoa >> {
      new PessoaDto().with {
        it.name = "jajajaa"
        it
      }
    }

    when: "buscar pessoa via url"
    def response = mockMvc.perform(get("/api/pessoa/10"))

    then: "deve retornar"
    /*and: "página com estatus 200 (OK)"
    response.andExpect(status().isOk())
    and: "o tipo da resposta deve ser json"
    response.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    and: "o nome deve ser igual a 'ajajajaj'"
    response.andExpect(jsonPath('$.name', is('jajajaa')))*/

  }

  @Unroll
  def "maximum of #a and #b is #c"() {
    expect:
    Math.max(a, b) == c

    where:
    a | b | c
    1 | 3 | 3
    7 | 4 | 7
    0 | 0 | 0
    0 | 0 | 0
  }


}
