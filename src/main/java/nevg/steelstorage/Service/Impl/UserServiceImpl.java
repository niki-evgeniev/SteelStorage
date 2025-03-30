package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.DTO.RegisterNewUser;
import nevg.steelstorage.Models.Entity.User;
import nevg.steelstorage.Models.Entity.UserRole;
import nevg.steelstorage.Models.Enums.RoleType;
import nevg.steelstorage.Repository.UserRepository;
import nevg.steelstorage.Repository.UserRoleRepository;
import nevg.steelstorage.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void addAdminProfile() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setEmail("admin@admin.bg");
            user.setFirstName("Admin");
            user.setLastName("Adminov");
            user.setPhoneNumber("12345");
            // pass is : 123
            String password = "123";
            user.setPassword(passwordEncoder.encode(password));
            List<UserRole> all = userRoleRepository.findAll();
            user.setRoles(all);
            user.setRegisterDate(LocalDateTime.now());
            userRepository.save(user);
        }
    }

    @Override
    public boolean checkEmailIsFree(String email) {
        Optional<User> checkEmail = userRepository.findByEmail(email);
        return checkEmail.isPresent();
    }

    @Override
    public boolean registerNewUser(RegisterNewUser registerNewUser) {
        User newUser = new User();
        newUser.setFirstName(registerNewUser.getFirstName());
        newUser.setLastName(registerNewUser.getLastName());
        newUser.setEmail(registerNewUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerNewUser.getPassword()));
        Optional<UserRole> byRoleType = userRoleRepository.findByRoleType(RoleType.USER);
        LocalDateTime timeNow = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        UserRole userRole = byRoleType.get();
        newUser.setRoles(List.of(userRole));
        newUser.setRegisterDate(timeNow);
        userRepository.save(newUser);
        return true;
    }


}
