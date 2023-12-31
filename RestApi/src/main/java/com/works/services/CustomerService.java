package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    final CustomerRepository customerRepository;
    final HttpServletRequest req;

    public ResponseEntity login(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findByUsernameEqualsAndPasswordEquals(customer.getUsername(), customer.getPassword());
        if (customerOptional.isPresent()) {
            Customer c = customerOptional.get();
            req.getSession().setAttribute("customer", c);
            return new ResponseEntity(c, HttpStatus.OK);
        }
        return new ResponseEntity(false, HttpStatus.UNAUTHORIZED);
    }

}
