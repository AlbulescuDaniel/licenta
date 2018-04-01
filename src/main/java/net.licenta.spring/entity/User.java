package net.licenta.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_USER")
public class User {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
