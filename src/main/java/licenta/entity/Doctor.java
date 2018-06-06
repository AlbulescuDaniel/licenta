package licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "T_DOCTOR")
@Entity
public class Doctor implements Serializable {
    private int idDoctor;
    private String firstName;
    private String lastName;
    private int age;
    private String department;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    private String password;
    private List<DoctorSpeciality> doctorSpecialitiesById = new ArrayList<>();
    private List<Prescription> prescriptionsById = new ArrayList<>();
    private Hospital hospital;
    private int hospitalID;

    public Doctor() {
    }

    @JsonIgnore
    @Id
    @Column(name = "IDDOCTOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Basic
    @Column(name = "First_Name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Last_Name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "Street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Zip_Code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @Basic
    @Column(name = "HospitalId")
    public int getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "doctorByDoctorId")
    public List<DoctorSpeciality> getDoctorSpecialitiesById() {
        return doctorSpecialitiesById;
    }

    public void setDoctorSpecialitiesById(List<DoctorSpeciality> doctorSpecialitiesById) {
        this.doctorSpecialitiesById = doctorSpecialitiesById;
    }

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "doctorByIdDoctor")
    public List<Prescription> getPrescriptionsById() {
        return prescriptionsById;
    }

    public void setPrescriptionsById(List<Prescription> prescriptionsById) {
        this.prescriptionsById = prescriptionsById;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HospitalId", insertable = false, updatable = false)
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
