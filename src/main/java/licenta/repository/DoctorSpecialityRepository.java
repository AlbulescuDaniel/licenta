package licenta.repository;

import licenta.entity.DoctorSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpeciality, Long> {

    List<DoctorSpeciality> findByIdDoc(Integer id);

    List<DoctorSpeciality> findAll();

}
