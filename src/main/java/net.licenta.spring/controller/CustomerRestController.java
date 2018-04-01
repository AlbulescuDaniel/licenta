package net.licenta.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.licenta.spring.dao.CustomerDAO;
import net.licenta.spring.model.Customer;

@RestController
public class CustomerRestController {

	
	private final CustomerDAO customerDAO;

    @Autowired
    public CustomerRestController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    @GetMapping("/customers")
	public List getCustomers() {
		return customerDAO.list();
	}

	@GetMapping("/")
	public String ll() {
		return "Welcome";
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@PostMapping(value = "/customers")
	public ResponseEntity createCustomer(@RequestBody Customer customer) {

		customerDAO.create(customer);

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == customerDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		customer = customerDAO.update(id, customer);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}
}