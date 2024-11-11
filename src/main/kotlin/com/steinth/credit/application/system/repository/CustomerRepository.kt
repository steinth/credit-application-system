package com.steinth.credit.application.system.repository

import com.steinth.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}