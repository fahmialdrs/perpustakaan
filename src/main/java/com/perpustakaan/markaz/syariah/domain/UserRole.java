package com.perpustakaan.markaz.syariah.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rizki on 01/06/15.
 */

@Entity
@Table(name = "tb_user_role")
public class UserRole implements Serializable{

    @Id
    @Column
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String idUserRole;

    @Column
    private String role = "ROLE_USER";

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    public String getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(String idUserRole) {
        this.idUserRole = idUserRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
