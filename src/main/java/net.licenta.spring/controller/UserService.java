package net.licenta.spring.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import net.licenta.spring.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	private static HashSet<User> users;
	{
		users = new HashSet();
		users.add(new User("John", "Doe"));
		users.add(new User("Russ", "Smith"));
		users.add(new User("Kate", "Williams"));
	}

	public HashSet list() {
		return users;
	}

	public void create(User user) {
		users.add(user);
	}
}