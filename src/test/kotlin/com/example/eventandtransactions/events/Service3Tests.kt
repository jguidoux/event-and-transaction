package com.example.eventandtransactions.events

import com.example.eventandtransactions.events.MyRepository3
import com.example.eventandtransactions.events.MyService3
import com.example.eventandtransactions.events.Objet3
import org.assertj.core.api.Assertions.assertThat
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
