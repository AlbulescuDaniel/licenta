package licenta.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "T_SPECIALITY")
public class Speciality implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name  = "SPECIALITY_NAME")
    private String prescriptionName;

    @Column(name  = "DESCRIPTION")
    private String description;

    public Speciality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "prescriptionName='" + prescriptionName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}