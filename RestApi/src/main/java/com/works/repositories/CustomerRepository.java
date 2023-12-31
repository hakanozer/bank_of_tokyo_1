package com.works.repositories;

import com.works.entities.Customer;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUsernameEqualsAndPasswordEquals(String username, String password);




}