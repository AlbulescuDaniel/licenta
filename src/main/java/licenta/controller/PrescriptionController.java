package licenta.controller;

import licenta.service.PrescriptionService;
import licenta.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/prescription")
@RestController
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("prescriptions")
    public  List<Prescription> getAllPrescriptions() {
        return prescriptionService.getPrescriptions();
    }

    @GetMapping("/patient")
    public  List<Prescription> getPrescriptionsByPatientEmail(@RequestParam(value = "email") String email,
                                                           @RequestParam(value = "fromDate") Date fromDate,
                                                           @RequestParam(value = "toDate") Date toDate) {
        return prescriptionService.getPatientPrescriptionsByPatientEmail(email, fromDate, toDate);
    }

    @GetMapping("/patient/cnp")
    public  List<Prescription> getPrescriptionsByPatientCNP(@RequestParam(value = "cnp") String cnp,
                                                           @RequestParam(value = "fromDate") Date fromDate,
                                                           @RequestParam(value = "toDate") Date toDate) {
        return prescriptionService.getPatientPrescriptionsByPatientCNP(cnp, fromDate, toDate);
    }
}