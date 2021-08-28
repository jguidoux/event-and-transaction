package com.example.eventandtransactions

import org.springframework.context.event.EventListener
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Service
@Transactional
class MyService4(val repository: MyRepository4) {
    fun userAction4(objet4: Objet4) {
        repository.save(objet4)
    }

    @EventListener
    fun handleUserAction2Done(event: UserAction2Done) {
        println("serivce4: Handling UserAction2Done")
        throw Exception()
    }
}

interface MyRepository4 : JpaRepository<Objet4, String>

@Entity
class Objet4(@Id var uuid : String = UUID.randomUUID().toString(), var message: String) {

}