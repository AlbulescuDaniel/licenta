package licenta.service;


import licenta.entity.Medicament;
import licenta.entity.Pharmacy;
import licenta.entity.PharmacyStock;
import licenta.error.CustomException;
import licenta.repository.MedicamentRepository;
import licenta.repository.PharmacyRepository;
import licenta.repository.PharmacyStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyService {

    private final MedicamentRepository medicamentRepository;
    private final PharmacyStockRepository pharmacyStockRepository;
    private final PharmacyRepository pharmacyRepository;

    @Autowired
    public PharmacyService(PharmacyStockRepository pharmacyStockRepository, PharmacyRepository pharmacyRepository, MedicamentRepository medicamentRepository) {
        this.pharmacyStockRepository = pharmacyStockRepository;
        this.pharmacyRepository = pharmacyRepository;
        this.medicamentRepository = medicamentRepository;
    }

    public List<Pharmacy> findPharmacyByMedicamentInStock(String medicamentName, String city) {
        System.out.println(medicamentName);
        Medicament medicament = medicamentRepository.findByName(medicamentName);

        if (medicament == null) {
            throw new CustomException("Medicament does not exist");
        }

        List<PharmacyStock> pharmacyStockList = pharmacyStockRepository.findByMedicamentId(medicament.getIdMedicament());

        List<Pharmacy> pharmacies = new ArrayList<>();

        pharmacyStockList.forEach(ps -> {
            Pharmacy pharmacy = pharmacyRepository.findByIDPharmacyAndByCity(ps.getPharmacyId(), city);
            if (pharmacy != null) {
                pharmacies.add(pharmacy);
                System.out.println(pharmacyRepository.findByIDPharmacyAndByCity(ps.getPharmacyId(), city));
            }
        });

        pharmacies.forEach(ps -> pharmacyStockList.forEach(ph -> {
            if (ph.getPharmacyId() == ps.getIDPharmacy()) {
                ps.getPharmacyStocksByIdPharmacy().add(ph);
            }
        }));
        return pharmacies;
    }
}