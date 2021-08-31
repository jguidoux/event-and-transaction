package com.example.eventandtransactions.aggregate

import org.jetbrains.annotations.NotNull
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size
import kotlin.collections.HashSet


interface UserRepository : JpaRepository<User, String>


/**
 * @see https://www.callicoder.com/hibernate-spring-boot-jpa-element-collection-demo/
 */
@Entity
class User(
    @Id
    var id: String = UUID.randomUUID().toString(),

    @NotNull
    @Size(max = 100)
    var name: String,

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    var email: String,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_phone_numbers", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "phone_number")
    var phone: Set<String> = HashSet(),

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_addresses", joinColumns = [JoinColumn(name = "user_id")])
    @AttributeOverrides( value =
        [
        AttributeOverride(name = "addressLine1", column = Column(name = "house_number")),
        AttributeOverride(name = "addressLine2", column = Column(name = "street"))
        ])
    var addresses: Set<Address> = HashSet()
)

@Embeddable
class Address(
    @NotNull
    @Size(max = 100)
    var addressLine1 : String,
    @NotNull
    @Size(max = 100)
    var addressLine2 : String,
    @NotNull
    @Size(max = 100)
    var city : String,
    @NotNull
    @Size(max = 100)
    var country : String,
    @NotNull
    @Size(max = 100)
    var zipCode : String,

)

