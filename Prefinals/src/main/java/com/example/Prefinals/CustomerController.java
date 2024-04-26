package com.example.Prefinals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editCustomer(@PathVariable("id") int customerId, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
        existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customerRepository.save(existingCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") int customerId) {
        customerRepository.deleteById(customerId);
    }
}
