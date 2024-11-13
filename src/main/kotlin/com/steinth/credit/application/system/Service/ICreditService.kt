package com.steinth.credit.application.system.Service

import com.steinth.credit.application.system.entity.Credit
import com.steinth.credit.application.system.entity.Customer
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit):Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, CreditCode: UUID): Credit

}