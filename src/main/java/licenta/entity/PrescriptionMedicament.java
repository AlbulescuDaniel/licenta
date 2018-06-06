package licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "T_PRESCRIPTION_MEDICAMENT")
@Entity
public class PrescriptionMedicament implements Serializable {
    private int id;
    private int prescriptionId;
    private int medicamentId;
    private int checked;
    private String description;
    private int pillsNumber;
    private Prescription prescriptionByPrescriptionId;
    private Medicament medicamentByMedicamentId;

    @JsonIgnore
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idPrescription")
    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @Basic
    @Column(name = "idMedicament")
    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }

    @Basic
    @Column(name = "checked")
    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "pillsNumber")
    public int getPillsNumber() {
        return pillsNumber;
    }

    public void setPillsNumber(int pillsNumber) {
        this.pillsNumber = pillsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionMedicament that = (PrescriptionMedicament) o;
        return id == that.id &&
                prescriptionId == that.prescriptionId &&
                medicamentId == that.medicamentId &&
                checked == that.checked &&
                pillsNumber == that.pillsNumber &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, prescriptionId, medicamentId, checked, description, pillsNumber);
    }

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    @JoinColumn(name = "idPrescription", insertable = false, updatable = false)
    public Prescription getPrescriptionByPrescriptionId() {
        return prescriptionByPrescriptionId;
    }

    public void setPrescriptionByPrescriptionId(Prescription prescriptionByPrescriptionId) {
        this.prescriptionByPrescriptionId = prescriptionByPrescriptionId;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    @JoinColumn(name = "idMedicament", insertable = false, updatable = false)
    public Medicament getMedicamentByMedicamentId() {
        return medicamentByMedicamentId;
    }

    public void setMedicamentByMedicamentId(Medicament medicamentByMedicamentId) {
        this.medicamentByMedicamentId = medicamentByMedicamentId;
    }
}
