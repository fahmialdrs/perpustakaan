package com.perpustakaan.markaz.syariah.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by rizki on 01/06/15.
 */

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enable = true;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserRole> userRoles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
