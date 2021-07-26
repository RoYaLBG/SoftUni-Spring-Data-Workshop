package com.example.demoWeb.services;

import com.example.demoWeb.dto.UserLoginDto;
import com.example.demoWeb.dto.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto user);

    Long validateUserLoginDetails(UserLoginDto user);

}
