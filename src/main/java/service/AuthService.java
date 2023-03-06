package service;


import models.dto.AuthDTO;
import models.form.LoginForm;
import models.form.RegisterUserForm;

public interface AuthService {

    AuthDTO login(LoginForm form);
    AuthDTO register(RegisterUserForm form);

}
