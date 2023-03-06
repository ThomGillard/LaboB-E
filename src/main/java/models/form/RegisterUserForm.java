package models.form;


import models.entity.User;
import models.entity.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterUserForm {

    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 4)
    private String password;

    @NotBlank
    private String email;

    public User toEntity(){

        User user = new User();

        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setRoles( Set.of(UserRole.STUDENT) );
        user.setEnabled(true);

        return user;

    }

}
