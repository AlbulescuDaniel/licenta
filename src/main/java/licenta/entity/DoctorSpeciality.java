package licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "T_DOCTOR_SPECIALITY")
@Entity
public class DoctorSpeciality implements Serializable {
    private int idDoc;
    private int idSpec;
    private int id;
    private Doctor doctorByDoctorId;
    private Speciality specialityBySpecialityId;

    public DoctorSpeciality(){}

    @Basic
    @Column(name = "idDoctor")
    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    @Basic
    @Column(name = "idSpeciality")
    public int getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(int idSpec) {
        this.idSpec = idSpec;
    }

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idDoctor", insertable = false, updatable = false)
    public Doctor getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorByDoctorId(Doctor doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }

    @ManyToOne
    @JoinColumn(name = "idSpeciality", insertable = false, updatable = false)
    public Speciality getSpecialityBySpecialityId() {
        return specialityBySpecialityId;
    }

    public void setSpecialityBySpecialityId(Speciality specialityBySpecialityId) {
        this.specialityBySpecialityId = specialityBySpecialityId;
    }
}
