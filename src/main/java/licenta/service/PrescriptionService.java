package licenta.service;

import licenta.entity.Prescription;
import licenta.error.CustomException;
import licenta.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionMedicamentRepository prescriptionMedicamentRepository;
    private final MedicamentRepository medicamentRepository;
    private final DoctorSpecialityRepository doctorSpecialityRepository;
    private final SpecialityRepository specialityRepository;
    private final DoctorRepository doctorRepository;
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository, DoctorRepository doctorRepository, SpecialityRepository specialityRepository, DoctorSpecialityRepository doctorSpecialityRepository, PrescriptionMedicamentRepository prescriptionMedicamentRepository, MedicamentRepository medicamentRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.doctorRepository = doctorRepository;
        this.specialityRepository = specialityRepository;
        this.doctorSpecialityRepository = doctorSpecialityRepository;
        this.prescriptionMedicamentRepository = prescriptionMedicamentRepository;
        this.medicamentRepository = medicamentRepository;
    }

    public List<Prescription> getPrescriptions() {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        if (prescriptions == null) {
            throw new CustomException("There are no prescriptions");
        }
        return prescriptions;
    }

    public List<Prescription> getPatientPrescriptionsByPatientEmail(String email, Date fromDate, Date toDate) {

        List<Prescription> prescriptions = prescriptionRepository.findByEmailBetweenDates(email, fromDate, toDate);

        if (prescriptions.size() == 0) {
            throw new CustomException("Patient does not have prescriptions");
        }
        return prescriptions;
    }

    public List<Prescription> getPatientPrescriptionsByPatientCNP(String cnp, Date fromDate, Date toDate) {

        List<Prescription> prescriptions = prescriptionRepository.findBycnpBetweenDates(cnp, fromDate, toDate);

        if (prescriptions.size() == 0) {
            throw new CustomException("Patient does not have prescriptions");
        }
        return prescriptions;
    }
}
