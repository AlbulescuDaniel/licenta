package licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_PHARMACY")
public class Pharmacy implements Serializable {

    private Integer IDPharmacy;
    private String pharmacyName;
    private String leadPharmacist;
    private String street;
    private String streetNumber;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    private List<PharmacyStock> pharmacyStocksByIdPharmacy;

    public Pharmacy() {
    }

    @JsonIgnore
    @Id
    @Column(name = "ID_PHARMACY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIDPharmacy() {
        return IDPharmacy;
    }

    public void setIDPharmacy(Integer IDPharmacy) {
        this.IDPharmacy = IDPharmacy;
    }

    @Column(name = "PHARMACY_NAME")
    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    @Column(name = "LEAD_PHARMACIST")
    public String getLeadPharmacist() {
        return leadPharmacist;
    }

    public void setLeadPharmacist(String leadPharmacist) {
        this.leadPharmacist = leadPharmacist;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "STREET_NUMBER")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "ZIP_CODE")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "pharmacyByPharmacyId")
    public List<PharmacyStock> getPharmacyStocksByIdPharmacy() {
        return pharmacyStocksByIdPharmacy;
    }

    public void setPharmacyStocksByIdPharmacy(List<PharmacyStock> pharmacyStocksByIdPharmacy) {
        this.pharmacyStocksByIdPharmacy = pharmacyStocksByIdPharmacy;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "IDPharmacy=" + IDPharmacy +
                ", pharmacyName='" + pharmacyName + '\'' +
                ", leadPharmacist='" + leadPharmacist + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", pharmacyStocksByIdPharmacy=" + pharmacyStocksByIdPharmacy +
                '}';
    }
}