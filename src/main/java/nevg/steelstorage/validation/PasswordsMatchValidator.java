package nevg.steelstorage.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nevg.steelstorage.Models.DTO.RegisterNewUser;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, RegisterNewUser> {
    @Override
    public boolean isValid(RegisterNewUser registerNewUser, ConstraintValidatorContext constraintValidatorContext) {
        if (registerNewUser.getPassword() == null || registerNewUser.getConfirmPassword() == null) {
            return false;
        }
        return registerNewUser.getPassword().equals(registerNewUser.getConfirmPassword());
    }
}
