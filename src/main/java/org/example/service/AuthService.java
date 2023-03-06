package org.example.service;


import org.example.models.dto.AuthDTO;
import org.example.models.form.LoginForm;
import org.example.models.form.RegisterUserForm;

public interface AuthService {

    AuthDTO login(LoginForm form);
    AuthDTO register(RegisterUserForm form);

}
