package com.perpustakaan.markaz.syariah.service.impl;

import com.perpustakaan.markaz.syariah.domain.User;
import com.perpustakaan.markaz.syariah.domain.UserRole;
import com.perpustakaan.markaz.syariah.repository.UserRepository;
import com.perpustakaan.markaz.syariah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rizki on 27/06/15.
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void saveUser(User user) {
        //lakukan enkripsi password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserRole userRole = new UserRole();
        userRole.setUser(user);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);

        user.setUserRoles(userRoles);

        userRepository.saveUser(user);
    }
}
