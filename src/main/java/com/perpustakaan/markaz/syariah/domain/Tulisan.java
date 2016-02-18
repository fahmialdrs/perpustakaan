package com.perpustakaan.markaz.syariah.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rizki on 27/06/15.
 */

@Entity
@Table(name = "tb_tulisan")
public class Tulisan implements Serializable{

    @Id
    @Column
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String idTulisan;

    @Column
    private String tulisan;

    @Column
    private String logo;

    @Column
    private boolean publish;

    public String getIdTulisan() {
        return idTulisan;
    }

    public void setIdTulisan(String idTulisan) {
        this.idTulisan = idTulisan;
    }

    public String getTulisan() {
        return tulisan;
    }

    public void setTulisan(String tulisan) {
        this.tulisan = tulisan;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }
}
