package com.steinth.credit.application.system.Service

import com.steinth.credit.application.system.entity.Customer

interface ICustomerService {

    fun save(customer: Customer):Customer

    fun finById(id: Long):Customer

    fun delete(id: Long)
}