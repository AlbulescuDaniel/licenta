package licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Table(name = "T_MEDICAMENT")
@Entity
public class Medicament implements Serializable{
    private int idMedicament;
    private String name;
    private String description;
    private String fabricant;
    private String activeComponent;
    private List<PrescriptionMedicament> prescriptionMedicamentsByIdMedicaments;
    private List<PharmacyStock> pharmacyStocksByIdMedicaments;


    @JsonIgnore
    @Id
    @Column(name = "ID_MEDICAMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
    }

    @Basic
    @Column(name = "MEDICAMENT_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "FABRICANT")
    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    @Basic
    @Column(name = "ACTIVE_COMPONENT")
    public String getActiveComponent() {
        return activeComponent;
    }

    public void setActiveComponent(String activeComponent) {
        this.activeComponent = activeComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicament that = (Medicament) o;
        return idMedicament == that.idMedicament &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(fabricant, that.fabricant) &&
                Objects.equals(activeComponent, that.activeComponent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMedicament, name, description, fabricant, activeComponent);
    }

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "medicamentByMedicamentId")
    public List<PrescriptionMedicament> getPrescriptionMedicamentsByIdMedicaments() {
        return prescriptionMedicamentsByIdMedicaments;
    }

    public void setPrescriptionMedicamentsByIdMedicaments(List<PrescriptionMedicament> prescriptionMedicamentsByIdMedicaments) {
        this.prescriptionMedicamentsByIdMedicaments = prescriptionMedicamentsByIdMedicaments;
    }

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "medicamentByIdMedicament")
    public List<PharmacyStock> getPharmacyStocksByIdMedicaments() {
        return pharmacyStocksByIdMedicaments;
    }

    public void setPharmacyStocksByIdMedicaments(List<PharmacyStock> pharmacyStocksByIdMedicaments) {
        this.pharmacyStocksByIdMedicaments = pharmacyStocksByIdMedicaments;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "idMedicament=" + idMedicament +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fabricant='" + fabricant + '\'' +
                ", activeComponent='" + activeComponent + '\'' +
                ", prescriptionMedicamentsByIdMedicaments=" + prescriptionMedicamentsByIdMedicaments +
                ", pharmacyStocksByIdMedicaments=" + pharmacyStocksByIdMedicaments +
                '}';
    }
}
