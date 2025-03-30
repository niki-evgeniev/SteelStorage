package nevg.steelstorage.Init;

import nevg.steelstorage.Service.SteelTypeService;
import nevg.steelstorage.Service.UserRoleService;
import nevg.steelstorage.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final UserService userService;
    private final SteelTypeService steelTypeService;

    public DataBaseInit(UserRoleService userRoleService, UserService userService, SteelTypeService steelTypeService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.steelTypeService = steelTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.addRoles();
        userService.addAdminProfile();
        steelTypeService.addSteel();
    }
}
