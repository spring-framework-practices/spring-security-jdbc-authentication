package com.trl.springsecurityjdbcauthentication.service;

import com.trl.springsecurityjdbcauthentication.controller.dto.UserDTO;

public interface UserService {

    UserDTO getUser(Long id);
}
