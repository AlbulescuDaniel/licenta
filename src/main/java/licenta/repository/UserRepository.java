package licenta.repository;

import licenta.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Client, Long> {

    Client findByUsernameAndPassword(String username, String password);

    List<Client> findAll();
}