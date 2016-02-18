package com.perpustakaan.markaz.syariah.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rizki on 27/06/15.
 */

@Entity
@Table(name = "tb_peminjaman")
public class Peminjaman implements Serializable{

    @Id
    @Column
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String idPeminjaman;

    @Column
    private String namaPeminjam;

    @Lob
    @Column
    private String alamat;

    @Column
    private String noKontak;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column
    private Date tglPeminjaman;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column
    private Date tglPengembalian;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "noUrut")
    private Buku buku;

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoKontak() {
        return noKontak;
    }

    public void setNoKontak(String noKontak) {
        this.noKontak = noKontak;
    }

    public Date getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(Date tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    public Date getTglPengembalian() {
        return tglPengembalian;
    }

    public void setTglPengembalian(Date tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }
}
