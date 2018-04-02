package licenta.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    @Column(name = "USERNAME")
    private String username;

    @Column
    private String password;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User(String firstName, String lastName) {
        this.username = firstName;
        this.password = lastName;
    }

    public User() {}

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
