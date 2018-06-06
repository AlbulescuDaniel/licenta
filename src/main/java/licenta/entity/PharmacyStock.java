package licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_PHARMACY_STOCK")
public class PharmacyStock {
    private int id;
    private int pharmacyId;
    private int medicamentId;
    private double price;
    private int quantity;
    private Pharmacy pharmacyByPharmacyId;
    private Medicament medicamentByIdMedicament;

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    @Id
    @Column(name = "ID_PHARMACY_STOCK")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PHARMACY_ID")
    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    @Basic
    @Column(name = "MEDICAMENT_ID")
    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyStock that = (PharmacyStock) o;
        return id == that.id &&
                pharmacyId == that.pharmacyId &&
                medicamentId == that.medicamentId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, pharmacyId, medicamentId);
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IDPharmacy", referencedColumnName = "ID_PHARMACY")
    public Pharmacy getPharmacyByPharmacyId() {
        return pharmacyByPharmacyId;
    }

    public void setPharmacyByPharmacyId(Pharmacy pharmacyByPharmacyId) {
        this.pharmacyByPharmacyId = pharmacyByPharmacyId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idMedicament", referencedColumnName = "ID_MEDICAMENT")
    public Medicament getMedicamentByIdMedicament() {
        return medicamentByIdMedicament;
    }

    public void setMedicamentByIdMedicament(Medicament medicamentByIdMedicament) {
        this.medicamentByIdMedicament = medicamentByIdMedicament;
    }

    @Override
    public String toString() {
        return "PharmacyStock{" +
                "id=" + id +
                ", pharmacyId=" + pharmacyId +
                ", medicamentId=" + medicamentId +
                ", pharmacyByPharmacyId=" + pharmacyByPharmacyId +
                ", medicamentByIdMedicament=" + medicamentByIdMedicament +
                '}';
    }
}
