package licenta.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "T_PRESCRIPTION")
public class Prescription implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name  = "PRESCRIPTION_NAME")
    private String prescriptionName;

    @Column(name  = "DESCRIPTION")
    private String description;

    @Column(name  = "SIDE_EFFECTS")
    private String sideEffects;

    public Prescription() {
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

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionName='" + prescriptionName + '\'' +
                ", description='" + description + '\'' +
                ", sideEffects='" + sideEffects + '\'' +
                '}';
    }
}
