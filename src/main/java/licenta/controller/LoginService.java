package licenta.controller;

import java.util.List;

import licenta.entity.Client;
import licenta.error.CustomException;
import licenta.repository.UserRepository;
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
    public Boolean isUserValid(Client client) {
        userRepository.deleteAll();

        Client ana = new Client("a", "a");
        Client bogdan = new Client("b", "b");
        userRepository.save(ana);
        userRepository.save(bogdan);

        Client result = userRepository.findByUsernameAndPassword(client.getFirstName(), client.getPassword());
        return result != null;
    }

    public List<Client> list() {

        List<Client> clients = userRepository.findAll();

        if(clients == null){
            throw new CustomException("There are no clients");
        }
        return clients;
    }

    public void create(Client client) {
        userRepository.save(client);
    }
}