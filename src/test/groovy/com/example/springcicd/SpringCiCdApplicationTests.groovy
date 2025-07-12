package com.example.springcicd

import com.example.springcicd.controller.HelloController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(HelloController)
class HelloControllerSpec extends Specification {

	@Autowired
	private MockMvc mockMvc

	def "should return hello message"() {
		expect:
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello CI/CD!"))
	}

}