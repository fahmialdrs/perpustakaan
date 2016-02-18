package com.perpustakaan.markaz.syariah.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */

@Entity
@Table(name = "tb_buku")
public class Buku implements Serializable{

    @Id
    @Column
    private String noUrut;

    @Column
    private String noKode;

    @Column
    private String fotoBuku;

    @Column
    private String warna;

    @Column
    private Integer ukuranP;

    @Column
    private Integer ukuranL;

    @Column
    private Integer tebal;

    @Column
    private Integer kertasP;

    @Column
    private Integer kertasL;

    @Column
    private String cover;

    @Column
    private String kategori;

    @Column
    private String jenis;

    @Column
    private String madzhab;

    @Column
    private String pentahqiq;

    @Column
    private String pentakhrij;

    @Column
    private String pengantar;

    @Column
    private String penterjemah;

    @Column
    private String pengedit;

    @Column
    private String penyalur;

    @Column
    private String cetakan;

    @Column
    private String tahun;

    @Column
    private String jilid;

    @Column
    private String juz;

    @Column
    private String eksemplar;

    @Column
    private String judul1;

    @Column
    private String pengarang1;

    @Column
    private String judul2;

    @Column
    private String pengarang2;

    @Column
    private String catatan;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "buku")
    private List<Peminjaman> peminjamans = new ArrayList<>();

    public String getNoKode() {
        return noKode;
    }

    public void setNoKode(String noKode) {
        this.noKode = noKode;
    }

    public String getFotoBuku() {
        return fotoBuku;
    }

    public void setFotoBuku(String fotoBuku) {
        this.fotoBuku = fotoBuku;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public Integer getUkuranP() {
        return ukuranP;
    }

    public void setUkuranP(Integer ukuranP) {
        this.ukuranP = ukuranP;
    }

    public Integer getUkuranL() {
        return ukuranL;
    }

    public void setUkuranL(Integer ukuranL) {
        this.ukuranL = ukuranL;
    }

    public Integer getTebal() {
        return tebal;
    }

    public void setTebal(Integer tebal) {
        this.tebal = tebal;
    }

    public Integer getKertasP() {
        return kertasP;
    }

    public void setKertasP(Integer kertasP) {
        this.kertasP = kertasP;
    }

    public Integer getKertasL() {
        return kertasL;
    }

    public void setKertasL(Integer kertasL) {
        this.kertasL = kertasL;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getMadzhab() {
        return madzhab;
    }

    public void setMadzhab(String madzhab) {
        this.madzhab = madzhab;
    }

    public String getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(String noUrut) {
        this.noUrut = noUrut;
    }

    public String getPentahqiq() {
        return pentahqiq;
    }

    public void setPentahqiq(String pentahqiq) {
        this.pentahqiq = pentahqiq;
    }

    public String getPentakhrij() {
        return pentakhrij;
    }

    public void setPentakhrij(String pentakhrij) {
        this.pentakhrij = pentakhrij;
    }

    public String getPengantar() {
        return pengantar;
    }

    public void setPengantar(String pengantar) {
        this.pengantar = pengantar;
    }

    public String getPenterjemah() {
        return penterjemah;
    }

    public void setPenterjemah(String penterjemah) {
        this.penterjemah = penterjemah;
    }

    public String getPengedit() {
        return pengedit;
    }

    public void setPengedit(String pengedit) {
        this.pengedit = pengedit;
    }

    public String getPenyalur() {
        return penyalur;
    }

    public void setPenyalur(String penyalur) {
        this.penyalur = penyalur;
    }

    public String getCetakan() {
        return cetakan;
    }

    public void setCetakan(String cetakan) {
        this.cetakan = cetakan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getJilid() {
        return jilid;
    }

    public void setJilid(String jilid) {
        this.jilid = jilid;
    }

    public String getJuz() {
        return juz;
    }

    public void setJuz(String juz) {
        this.juz = juz;
    }

    public String getEksemplar() {
        return eksemplar;
    }

    public void setEksemplar(String eksemplar) {
        this.eksemplar = eksemplar;
    }

    public String getJudul1() {
        return judul1;
    }

    public void setJudul1(String judul1) {
        this.judul1 = judul1;
    }

    public String getPengarang1() {
        return pengarang1;
    }

    public void setPengarang1(String pengarang1) {
        this.pengarang1 = pengarang1;
    }

    public String getJudul2() {
        return judul2;
    }

    public void setJudul2(String judul2) {
        this.judul2 = judul2;
    }

    public String getPengarang2() {
        return pengarang2;
    }

    public void setPengarang2(String pengarang2) {
        this.pengarang2 = pengarang2;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public List<Peminjaman> getPeminjamans() {
        return peminjamans;
    }

    public void setPeminjamans(List<Peminjaman> peminjamans) {
        this.peminjamans = peminjamans;
    }
}
