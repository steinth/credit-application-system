package com.steinth.credit.application.system.entity

import com.steinth.credit.application.system.enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Credit")
data class Credit(
    @Column(name = "CreditCode", unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(name = "CreditValue") val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(name = "DayFirstIntallment") val dayFirstInstallment: LocalDate,
    @Column(name = "NumberOfFirstInstallments") val numberOfInstallments: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    val status: Status = Status.IN_PROGRESS,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    var customer: Customer? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
