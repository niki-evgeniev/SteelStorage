package nevg.steelstorage.Init;

import nevg.steelstorage.Service.SteelService;
import nevg.steelstorage.Service.UserRoleService;
import nevg.steelstorage.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final UserService userService;
    private final SteelService steelService;

    public DataBaseInit(UserRoleService userRoleService, UserService userService, SteelService steelService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.steelService = steelService;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.addRoles();
        userService.addAdminProfile();
        steelService.addSteel();
    }
}
