package com.example.eventandtransactions.events

import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Service
@Transactional
class MyService1(val repository: MyRepository1, val publisher: ApplicationEventPublisher) {
    fun userAction1(objet1: Objet1) {
        repository.save(objet1)
        publisher.publishEvent(UserAction1Done())
    }

    fun userAction2(objet1: Objet1) {
        repository.save(objet1)
        publisher.publishEvent(UserAction2Done())
    }

}

interface MyRepository1 : JpaRepository<Objet1, String>

@Entity
class Objet1(@Id var uuid : String = UUID.randomUUID().toString(), var message: String) {

}