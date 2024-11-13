package com.steinth.credit.application.system.Service.impl

import com.steinth.credit.application.system.Service.ICustomerService
import com.steinth.credit.application.system.entity.Customer
import com.steinth.credit.application.system.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    override fun finById(id: Long): Customer {
        return customerRepository.findById(id).orElseThrow(){
            throw RuntimeException("id $id not found")
        }
    }

    override fun delete(id: Long){
        return customerRepository.deleteById(id)
    }
}