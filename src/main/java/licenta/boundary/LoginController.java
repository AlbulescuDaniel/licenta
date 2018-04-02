package licenta.boundary;

import java.util.List;

import licenta.controller.LoginService;
import licenta.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class LoginController {

    private final LoginService userService;

    @Autowired()
    public LoginController(LoginService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
                return userService.isUserValid(user);
          }

    @GetMapping("/list")
	public List<User> getCustomers() {
		return userService.list();
	}

	@GetMapping("/")
	public String index() {
		return "Welcome";
	}

	@PostMapping(value = "/create")
	public ResponseEntity<User> createCustomer(@RequestBody User user) {

		userService.create(user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}