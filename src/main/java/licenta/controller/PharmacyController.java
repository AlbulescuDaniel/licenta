package licenta.controller;

import licenta.service.PharmacyService;
import licenta.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/pharmacy")
@RestController
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @Autowired
    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/medicament")
    public List<Pharmacy> getAll(@RequestParam(value = "medicament") String medicament,
                                 @RequestParam(value = "city") String city){
        return pharmacyService.findPharmacyByMedicamentInStock(medicament, city);
    }
}
