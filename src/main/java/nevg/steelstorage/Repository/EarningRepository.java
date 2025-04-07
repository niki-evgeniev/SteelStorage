package nevg.steelstorage.Repository;

import nevg.steelstorage.Models.Entity.Earnings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EarningRepository extends JpaRepository<Earnings, UUID> {
}
