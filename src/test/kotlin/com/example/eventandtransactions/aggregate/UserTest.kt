package com.example.eventandtransactions.aggregate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class UserTest {

    @Autowired
    lateinit var repository: UserRepository

    @Test
    fun `devrait pouvoir inserer un utilisateur`() {

        val myUser = User(
            name = "jerem",
            email = "jerem@mail.com",
            phone = setOf("00336000000", "0003336000000"),
            addresses = setOf(
                Address(
                    addressLine1 = "234",
                    addressLine2 = "rue du chat",
                    city = "Rennes",
                    zipCode = "35000",
                    country = "France"
                ),
                Address(
                    addressLine1 = "12",
                    addressLine2 = "rue du chien",
                    city = "Guerande",
                    zipCode = "44350",
                    country = "France"
                )
                )
        )

        repository.save(myUser)

        assertThat(repository.existsById(myUser.id)).isTrue
    }
}