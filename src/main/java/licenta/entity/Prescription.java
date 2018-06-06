package licenta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_PRESCRIPTION")
public class Prescription implements Serializable {
    private int idPrescription;
    private int idDoctor;
    private int idPatient;
    private String diagnostic;
    private int days;
    private Date datePrescripted;
    private Doctor doctorByIdDoctor;
    private Patient patientByIdPatient;
    private List<PrescriptionMedicament> prescriptionMedicamentsByIdPrescription;

    public Prescription() {}

    @Basic
    @Column(name = "idDoctor")
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Basic
    @Column(name = "idPatient")
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    @JsonIgnore
    @Id
    @Column(name = "ID_PRESCRIPTION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(int idPrescription) {
        this.idPrescription = idPrescription;
    }

    @Basic
    @Column(name = "diagnostic")
    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    @Basic
    @Column(name = "days")
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Basic
    @Column(name = "datePrescripted")
    public Date getDatePrescripted() {
        return datePrescripted;
    }

    public void setDatePrescripted(Date datePrescripted) {
        this.datePrescripted = datePrescripted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return idPrescription == that.idPrescription &&
                days == that.days &&
                Objects.equals(diagnostic, that.diagnostic) &&
                Objects.equals(datePrescripted, that.datePrescripted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPrescription, diagnostic, days, datePrescripted);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", insertable = false, updatable = false)
    public Doctor getDoctorByIdDoctor() {
        return doctorByIdDoctor;
    }

    public void setDoctorByIdDoctor(Doctor doctorByIdDoctor) {
        this.doctorByIdDoctor = doctorByIdDoctor;
    }

    @ManyToOne
    @JoinColumn(name = "idPatient", insertable = false, updatable = false)
    @JsonBackReference
    public Patient getPatientByIdPatient() {
        return patientByIdPatient;
    }

    public void setPatientByIdPatient(Patient patientByIdPatient) {
        this.patientByIdPatient = patientByIdPatient;
    }

    @OneToMany(mappedBy = "prescriptionByPrescriptionId", fetch = FetchType.EAGER)
    public List<PrescriptionMedicament> getPrescriptionMedicamentsByIdPrescription() {
        return prescriptionMedicamentsByIdPrescription;
    }

    public void setPrescriptionMedicamentsByIdPrescription(List<PrescriptionMedicament> prescriptionMedicamentsByIdPrescription) {
        this.prescriptionMedicamentsByIdPrescription = prescriptionMedicamentsByIdPrescription;
    }
}