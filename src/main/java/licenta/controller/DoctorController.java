package licenta.controller;

import licenta.service.DoctorService;
import licenta.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("doctor")
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{email}")
    public Doctor list(@PathVariable String email){
        Doctor doctor = doctorService.getOneDoctor(email);
        return doctor;
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody Doctor doctor) {
        return doctorService.isUserValid(doctor);
    }
}
