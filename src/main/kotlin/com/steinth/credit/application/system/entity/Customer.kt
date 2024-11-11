package com.steinth.credit.application.system.entity

import jakarta.persistence.*

@Entity
@Table(name = "Cliente")
data class Customer(
    @Column(name = "FirstName") var firstName: String = "",
    @Column(name = "LastName") var lastName: String = "",
    @Column(name = "CPF", unique = true) val cpf: String,
    @Column(name = "Email", unique = true) var email: String = "",
    @Column(name = "Password") var password: String = "",

    @Embedded
    var address: Address = Address(),

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.REMOVE, CascadeType.PERSIST],
        mappedBy = "customer"
    )
    var credits: MutableList<Credit> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null
)
