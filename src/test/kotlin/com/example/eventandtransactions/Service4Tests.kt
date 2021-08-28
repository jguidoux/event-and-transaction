package com.example.eventandtransactions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Service4Tests {


	@Autowired
	lateinit var  service4: MyService4
	@Autowired
	lateinit var  repository4: MyRepository4

	@Test
	fun `devrait pouvoir inserer un objet4`() {
		val objet4 = Objet4(message = "Objet4")
		service4.userAction4(objet4)

		assertThat(repository4.count()).isEqualTo(1)
		assertThat(repository4.existsById(objet4.uuid)).isTrue
	}

	@BeforeEach
	internal fun setUP() {
		println("On vide la bdd")
		repository4.deleteAll()
	}
}
