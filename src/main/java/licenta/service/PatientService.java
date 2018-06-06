package licenta.service;

import java.util.List;

import licenta.entity.*;
import licenta.error.CustomException;
import licenta.repository.*;
import licenta.util.RandomString;
import licenta.util.SendHTMLEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository userRepository) {
        this.patientRepository = userRepository;

    }

    public boolean isUserValid(Patient patient) {
        return patientRepository.findByEmailAndPassword(patient.getEmail(), patient.getPassword()) != null;
    }

    public List<Patient> getAllPatients(){

        List<Patient> patients;

        patients = patientRepository.findAll();

        if(patients.size() == 0){
            throw new CustomException("There is no patients");
        }

        return patients;
    }

    public boolean create(Patient patient) {
        RandomString pass = new RandomString(12);

        if(patientRepository.findByEmail(patient.getEmail()) != null){
            return false;
        }
        patient.setPassword(pass.nextString());
        System.out.println(patient.getPassword());
        patientRepository.save(patient);
        SendHTMLEmail.send();

        return true;
    }
}