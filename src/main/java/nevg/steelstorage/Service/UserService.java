package nevg.steelstorage.Service;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.ErrorRegisterNewUser;
import nevg.steelstorage.Models.DTO.RegisterNewUser;

import java.util.List;

public interface UserService {

    void addAdminProfile();

    boolean checkEmailIsFree(String email);

    boolean registerNewUser(RegisterNewUser registerNewUser);
}
