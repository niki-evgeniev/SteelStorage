package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.Entity.UserRole;
import nevg.steelstorage.Models.Enums.RoleType;
import nevg.steelstorage.Repository.UserRoleRepository;
import nevg.steelstorage.Service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {


    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void addRoles() {
        if (userRoleRepository.count() == 0) {
            RoleType[] values = RoleType.values();
            for (RoleType value : values) {
                UserRole userRole = new UserRole();
                userRole.setRoleType(value);
                userRoleRepository.save(userRole);
            }
        }
    }
}
