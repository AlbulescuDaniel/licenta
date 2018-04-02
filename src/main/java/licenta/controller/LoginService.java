package licenta.controller;

import java.util.ArrayList;
import java.util.List;

import licenta.entity.User;
import licenta.error.CustomException;
import licenta.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Boolean isUserValid(User user) {
        userRepository.deleteAll();

        User ana = new User("a", "a");
        User bogdan = new User("b", "b");
        userRepository.save(ana);
        userRepository.save(bogdan);

        User result = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return result != null;
    }

    public List<User> list() {

        List<User> users  = userRepository.findAll();

        if(users == null){
            throw new CustomException("There are no users");
        }
        return users;
    }

    public void create(User user) {
        userRepository.save(user);
    }
}