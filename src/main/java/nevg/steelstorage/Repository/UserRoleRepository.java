package nevg.steelstorage.Repository;

import nevg.steelstorage.Models.Entity.UserRole;
import nevg.steelstorage.Models.Enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

//    Optional<UserRole> findByRoleType(String roleType);

    Optional<UserRole> findByRoleType(RoleType roleType);

}
