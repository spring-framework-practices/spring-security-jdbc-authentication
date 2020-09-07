package com.trl.springsecurityjdbcauthentication.service.impl;

import com.trl.springsecurityjdbcauthentication.controller.dto.UserDTO;
import com.trl.springsecurityjdbcauthentication.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO getUser(Long id) {
        return null;
    }
}
