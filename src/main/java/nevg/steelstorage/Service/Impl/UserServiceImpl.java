package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.Entity.User;
import nevg.steelstorage.Repository.UserRepository;
import nevg.steelstorage.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addAdminProfile() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setEmail("admin@admin.bg");
            user.setFirstName("Admin");
            user.setLastName("Adminov");
            user.setPhoneNumber("12345");
            user.setPassword("1234");
            userRepository.save(user);
        }
    }
}
