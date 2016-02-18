package com.perpustakaan.markaz.syariah.repository.impl;

import com.perpustakaan.markaz.syariah.domain.User;
import com.perpustakaan.markaz.syariah.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rizki on 01/06/15.
 */

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

    public User findUserByUsername(String username) {
        LOGGER.debug("find user by username {}", username);

        List<User> users = sessionFactory
                .getCurrentSession()
                .createQuery("select u from User u left join fetch u.userRoles ur where u.username = :username")
                .setParameter("username", username)
                .list();

        if(users == null){
            return null;
        }else if(users.size() <= 0){
            return null;
        }else{
            LOGGER.debug("Hasil Query untuk login {}", users.get(0).getUsername());
            return users.get(0);
        }
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
