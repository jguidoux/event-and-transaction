package com.example.eventandtransactions.events

import com.example.eventandtransactions.events.MyRepository1
import com.example.eventandtransactions.events.MyService1
import com.example.eventandtransactions.events.Objet1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Service1Tests {


	@Autowired
	lateinit var  service1: MyService1
	@Autowired
	lateinit var  repository1: MyRepository1

	@Test
	fun `devrait pouvoir inserer un objet1`() {
		val objet1 = Objet1(message = "Objet1")
		service1.userAction1(objet1)

		assertThat(repository1.count()).isEqualTo(1)
		assertThat(repository1.existsById(objet1.uuid)).isTrue
	}

	@BeforeEach
	internal fun setUP() {
		println("On vide la bdd")
		repository1.deleteAll()
	}
}
