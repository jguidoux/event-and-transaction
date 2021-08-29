package com.example.eventandtransactions.events

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EventsTests {


    @Autowired
    lateinit var service1: MyService1

    @Autowired
    lateinit var repository1: MyRepository1

    @Autowired
    lateinit var repository2: MyRepository2

    @Autowired
    lateinit var repository3: MyRepository3

    @Autowired
    lateinit var repository4: MyRepository4

    @Test
    fun `devrait inserer objets 2 et 3 quand on insere un objet1`() {
        val objet1 = Objet1(message = "Objet1")
        service1.userAction1(objet1)

        assertThat(repository1.count()).isEqualTo(1)
        assertThat(repository2.count()).isEqualTo(1)
        assertThat(repository3.count()).isEqualTo(1)
        assertThat(repository4.count()).isEqualTo(0)
        assertThat(repository1.existsById(objet1.uuid)).isTrue
        assertThat(repository2.findAll().first().message).isEqualTo("Service 2 : Object insertion due to UserAction1Done Event")
        assertThat(repository3.findAll().first().message).isEqualTo("Service 3 : Object insertion due to UserAction1Done Event")
    }

    @Test
    fun `devrait avoir un rollback quand il y a une exception`() {
        val objet1 = Objet1(message = "Objet1")
        try {
            service1.userAction2(objet1)
			fail("Une exception devrait etre lancee")
        } catch (e: Exception) {

            assertThat(repository1.count()).isEqualTo(0)
            assertThat(repository2.count()).isEqualTo(0)
            assertThat(repository3.count()).isEqualTo(0)
            assertThat(repository4.count()).isEqualTo(0)
        }

    }

	@BeforeEach
	internal fun setUP() {
		println("On vide la bdd")
		repository1.deleteAll()
		repository2.deleteAll()
		repository3.deleteAll()
		repository4.deleteAll()
	}
}
