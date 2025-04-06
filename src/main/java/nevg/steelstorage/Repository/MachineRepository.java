package nevg.steelstorage.Repository;

import nevg.steelstorage.Models.Entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MachineRepository extends JpaRepository<Machine, UUID> {

    Optional<Machine> findBySerialNumber(String serialNumber);

}
