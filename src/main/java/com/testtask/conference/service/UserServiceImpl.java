package com.testtask.conference.service;

import com.testtask.conference.dao.ConfRepository;
import com.testtask.conference.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl //implements UserService
{
    @Autowired
    private ConfRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

}
