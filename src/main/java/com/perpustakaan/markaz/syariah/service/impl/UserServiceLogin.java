package com.perpustakaan.markaz.syariah.service.impl;

import com.perpustakaan.markaz.syariah.domain.UserRole;
import com.perpustakaan.markaz.syariah.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by rizki on 01/06/15.
 */

@Service
public class UserServiceLogin implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceLogin.class);

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        LOGGER.debug("isi username {}", s);

        com.perpustakaan.markaz.syariah.domain.User user = userRepository.findUserByUsername(s);

        if(user == null){
            return null;
        }

        LOGGER.debug("hasil query pada user service {}", user.getUsername());

        List<GrantedAuthority> grantedAuthorities = buildUserAuthority(user.getUserRoles());

        return buildUserForAuthentication(user, grantedAuthorities);
    }

    private User buildUserForAuthentication(com.perpustakaan.markaz.syariah.domain.User user, List<GrantedAuthority> grantedAuthorities) {
        return new User(user.getUsername(), user.getPassword(), user.getEnable(), true, true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthorities = userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRole())).collect(Collectors.toSet());

        return new ArrayList<>(grantedAuthorities);
    }
}
