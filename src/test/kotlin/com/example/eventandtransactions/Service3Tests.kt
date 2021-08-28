package com.example.eventandtransactions

import org.aspectj.lang.annotation.Before
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Service3Tests {


	@Autowired
	lateinit var  service3: MyService3
	@Autowired
	lateinit var  repository3: MyRepository3

	@Test
	fun `devrait pouvoir inserer un objet3`() {
		val objet3 = Objet3(message = "Objet3")
		service3.userAction3(objet3)

		assertThat(repository3.count()).isEqualTo(1)
		assertThat(repository3.existsById(objet3.uuid)).isTrue
	}

	@BeforeEach
	internal fun setUP() {
		println("On vide la bdd")
		repository3.deleteAll()
	}
}
