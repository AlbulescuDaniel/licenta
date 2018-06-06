package licenta.service;

import licenta.entity.Hospital;
import licenta.error.CustomException;
import licenta.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    private HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Hospital> findHospitalsByCity(String city){
        List<Hospital> hospitals = hospitalRepository.findByCity(city);

        if(hospitals.size() == 0)
            throw new CustomException("Could not found an hospital in this city");

        return hospitals;
    }
}
