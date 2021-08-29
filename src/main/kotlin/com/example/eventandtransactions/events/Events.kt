package com.example.eventandtransactions.events

import java.time.LocalDateTime

sealed interface DomainEvents {
    val occuredOn: LocalDateTime
}

data class UserAction1Done(override val occuredOn: LocalDateTime = LocalDateTime.now()): DomainEvents
data class UserAction2Done(override val occuredOn: LocalDateTime = LocalDateTime.now()): DomainEvents