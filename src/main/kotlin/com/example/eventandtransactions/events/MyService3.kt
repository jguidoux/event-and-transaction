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
class MyService3(val repository: MyRepository3) {
    fun userAction3(objet3: Objet3) {
        repository.save(objet3)
    }

    @EventListener
    fun handleUserAction1Done(event: UserAction1Done) {
        println("Handling UserAction1Done")
        repository.save(Objet3(message = "Service 3 : Object insertion due to UserAction1Done Event"))
    }

    @EventListener
    fun handleUserAction2Done(event: UserAction2Done) {
        println("serivce3: Handling UserAction2Done")
        repository.save(Objet3(message = "Service 3 : Object insertion due to UserAction2Done Event"))
    }

}

interface MyRepository3 : JpaRepository<Objet3, String>

@Entity
class Objet3(@Id var uuid : String = UUID.randomUUID().toString(), var message: String) {

}