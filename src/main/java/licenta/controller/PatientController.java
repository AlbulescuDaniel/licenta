package licenta.controller;

import java.util.List;

import licenta.service.PatientService;
import licenta.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/patient")
@RestController
public class PatientController {

    private PatientService patientService;

    @Autowired()
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Patient patient) {
        return patientService.isUserValid(patient);
    }

    @GetMapping("/patients")
    public List<Patient> getAll(){
        return patientService.getAllPatients();
    }

	@PostMapping(value = "/register")
	public boolean createPatient(@RequestBody Patient patient) {

		return patientService.create(patient);
	}
}