package nevg.steelstorage.Repository;

import nevg.steelstorage.Models.Entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MachineRepository extends JpaRepository<Machine, UUID> {

    Optional<Machine> findBySerialNumber(String serialNumber);

    Optional<Machine> findByBrand(String brand);

    Optional<Machine> findOneByModel(String model);

    List<Machine> findByModel(String model);

    List<Machine> findAllByModelContains(String model);

}
