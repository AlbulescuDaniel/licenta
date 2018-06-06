package licenta.service;

import licenta.entity.Doctor;
import licenta.repository.DoctorRepository;
import licenta.repository.DoctorSpecialityRepository;
import licenta.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final SpecialityRepository specialityRepository;
    private final DoctorSpecialityRepository doctorSpecialityRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, SpecialityRepository specialityRepository, DoctorSpecialityRepository doctorSpecialityRepository) {
        this.doctorRepository = doctorRepository;
        this.specialityRepository = specialityRepository;
        this.doctorSpecialityRepository = doctorSpecialityRepository;
    }

    public  Boolean isUserValid(Doctor doctor){

        return doctorRepository.findByEmailAndPassword(doctor.getEmail(), doctor.getPassword()) != null;
    }

    public Doctor getOneDoctor(String email) {
        return doctorRepository.findByEmail(email);
    }

    public List<Doctor> GetAllDoctors(){
        return doctorRepository.findAll();
    }
}