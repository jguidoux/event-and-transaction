package com.example.eventandtransactions.events

import org.springframework.context.event.EventListener
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Service
@Transactional
class MyService2(val repository: MyRepository2) {
    fun userAction2(objet2: Objet2) {
        repository.save(objet2)
    }

    @EventListener
    fun handleUserAction1Done(event: UserAction1Done) {
        println("Handling UserAction1Done")
        repository.save(Objet2(message = "Service 2 : Object insertion due to UserAction1Done Event"))
    }
    @EventListener
    fun handleUserAction2Done(event: UserAction2Done) {
        println("serivce2: Handling UserAction2Done")
        repository.save(Objet2(message = "Service 2 : Object insertion due to UserAction2Done Event"))
    }
}

interface MyRepository2 : JpaRepository<Objet2, String>

@Entity
class Objet2(@Id var uuid : String = UUID.randomUUID().toString(), var message: String) {

}