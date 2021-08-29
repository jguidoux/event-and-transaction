package com.example.eventandtransactions.events

import com.example.eventandtransactions.events.MyRepository2
import com.example.eventandtransactions.events.MyService2
import com.example.eventandtransactions.events.Objet2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Service2Tests {


	@Autowired
	lateinit var  service2: MyService2
	@Autowired
	lateinit var  repository2: MyRepository2

	@Test
	fun `devrait pouvoir inserer un objet2`() {
		val objet2 = Objet2(message = "Objet2")
		service2.userAction2(objet2)

		assertThat(repository2.count()).isEqualTo(1)
		assertThat(repository2.existsById(objet2.uuid)).isTrue
	}

	@BeforeEach
	internal fun setUP() {
		println("On vide la bdd")
		repository2.deleteAll()
	}

}
