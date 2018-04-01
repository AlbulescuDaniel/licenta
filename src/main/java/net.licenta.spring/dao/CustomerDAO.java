package net.licenta.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.licenta.spring.model.Customer;

@Component
public class CustomerDAO {

	private static List<Customer> customers;
	{
		customers = new ArrayList();
		customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
		customers.add(new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
		customers.add(new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
		customers.add(new Customer(System.currentTimeMillis(), "Viral", "Patel", "vpatel@gmail.com", "356-758-8736"));
	}

	public List list() {
		return customers;
	}

	public Customer get(Long id) {

		for (Customer c : customers) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public void create(Customer customer) {
		customer.setId(System.currentTimeMillis());
		customers.add(customer);
	}

	public Long delete(Long id) {

		for (Customer c : customers) {
			if (c.getId().equals(id)) {
				customers.remove(c);
				return id;
			}
		}

		return null;
	}

	public Customer update(Long id, Customer customer) {

		for (Customer c : customers) {
			if (c.getId().equals(id)) {
				customer.setId(c.getId());
				customers.remove(c);
				customers.add(customer);
				return customer;
			}
		}

		return null;
	}

}