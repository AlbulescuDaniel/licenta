package licenta.boundary;

import java.util.List;

import licenta.controller.LoginService;
import licenta.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class LoginController {

    private LoginService userService;

    @Autowired()
    public LoginController(LoginService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Client client) {
                return userService.isUserValid(client);
          }

    @GetMapping("/list")
	public List<Client> getCustomers() {
		return userService.list();
	}

	@GetMapping("/")
	public String index() {
		return "Welcome";
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Client> createCustomer(@RequestBody Client client) {

		userService.create(client);

		return new ResponseEntity<>(client, HttpStatus.OK);
	}
}