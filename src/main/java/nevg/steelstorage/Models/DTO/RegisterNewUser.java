package nevg.steelstorage.Models.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import nevg.steelstorage.validation.PasswordsMatch;

@PasswordsMatch
public class RegisterNewUser {

    @NotEmpty(message = "{fist_name_not_empty}")
    @Size(min = 3, max = 20, message = "{first_name_length}")
    private String firstName;

    @NotEmpty(message = "{last_name_length}")
    @Size(min = 3, max = 20, message = "{last_name_not_empty}")
    private String lastName;

    @NotEmpty(message = "{email_is_not_empty}")
    @Email(message = "{email_is_incorrect}")
    private String email;

    @NotEmpty(message = "{password_is_empty}")
    @Size(min = 2, max = 50, message = "{password_length}")
    private String password;

    @NotEmpty(message = "{confirm_password_is_empty}")
    @Size(min = 2, max = 50, message = "{confirm_password_length}")
    private String confirmPassword;

    public RegisterNewUser() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
