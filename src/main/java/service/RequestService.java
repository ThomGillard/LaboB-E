package service;



import models.dto.RequestDTO;
import models.form.RequestNewForm;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface RequestService {
    List<RequestDTO> getAllSelf(Authentication auth);
    RequestDTO getOne(Long id);
    void insert(RequestNewForm form, Authentication auth);
    void delete(long id);
    List<RequestDTO> getAll();

    void refuse(long id);
}
