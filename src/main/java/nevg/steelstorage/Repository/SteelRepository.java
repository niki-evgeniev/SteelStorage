package nevg.steelstorage.Repository;

import nevg.steelstorage.Models.Entity.Steel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SteelRepository extends JpaRepository<Steel, UUID> {
}
