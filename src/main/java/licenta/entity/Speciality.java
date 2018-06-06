package licenta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "T_SPECIALITY")
@Entity
public class Speciality implements Serializable{
    private int idSpeciality;
    private String name;
    private String description;
    private List<DoctorSpeciality> doctorSpecialitiesById;

    public Speciality(){}

    @JsonIgnore
    @Id
    @Column(name = "ID_SPECIALITY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    @Basic
    @Column(name = "SPECIALITY_NAME")
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

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "specialityBySpecialityId")
    public List<DoctorSpeciality> getDoctorSpecialitiesById() {
        return doctorSpecialitiesById;
    }

    public void setDoctorSpecialitiesById(List<DoctorSpeciality> doctorSpecialitiesById) {
        this.doctorSpecialitiesById = doctorSpecialitiesById;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "idSpeciality=" + idSpeciality +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", doctorSpecialitiesById=" + doctorSpecialitiesById +
                '}';
    }
}
