package net.licenta.spring.boundary;

import java.util.HashSet;

import net.licenta.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.licenta.spring.controller.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	private UserService customerDAO;

    @Autowired
    public UserController(UserService customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/list")
	public HashSet getCustomers() {
		return customerDAO.list();
	}

	@GetMapping("/")
	public String ll() {
		return "Welcome";
	}

	@PostMapping(value = "/create")
	public ResponseEntity<User> createCustomer(@RequestBody User user) {

		customerDAO.create(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}