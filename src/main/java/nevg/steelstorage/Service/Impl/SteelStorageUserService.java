package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.Entity.User;
import nevg.steelstorage.Models.Entity.UserRole;
import nevg.steelstorage.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SteelStorageUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public SteelStorageUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByEmail(email)
                .map(SteelStorageUserService::mapUser)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found"));

        System.out.printf("LOGIN USER " +  userDetails.getUsername() + "%n");
        return userDetails;
    }

    private static UserDetails mapUser(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoles()
                        .stream()
                        .map(SteelStorageUserService::map)
                        .toList())
                .build();
    }

    private static GrantedAuthority map(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole.getRoleType().name());
    }
}
