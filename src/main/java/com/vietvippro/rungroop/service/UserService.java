package com.vietvippro.rungroop.service;

import com.vietvippro.rungroop.dto.RegistrationDto;
import com.vietvippro.rungroop.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
