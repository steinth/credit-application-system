package com.steinth.credit.application.system.Service.impl

import com.steinth.credit.application.system.Service.ICreditService
import com.steinth.credit.application.system.entity.Credit
import com.steinth.credit.application.system.repository.CreditRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.finById(credit.customer?.id!!)
        }
        return creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return creditRepository.findAllByCredits(customerId)
    }

    override fun findByCreditCode(customerId: Long ,creditCode: UUID): Credit {
        val credit:Credit = (creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Creditcode $creditCode not found"))
        return if(credit.customer?.id == customerId) credit else throw RuntimeException("contact admin")
    }
}