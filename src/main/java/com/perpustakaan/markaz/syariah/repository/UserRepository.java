package com.perpustakaan.markaz.syariah.repository;

import com.perpustakaan.markaz.syariah.domain.User;

/**
 * Created by rizki on 01/06/15.
 */
public interface UserRepository {
    User findUserByUsername(String username);
    void saveUser(User user);
}
