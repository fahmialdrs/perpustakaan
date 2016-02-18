package com.perpustakaan.markaz.syariah.service;

import com.perpustakaan.markaz.syariah.domain.Peminjaman;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */
public interface PeminjamanService {
    void save(Peminjaman peminjaman, String noKode);
    void delete(String idPeminjaman);
    Peminjaman getPeminjaman(String idPeminjaman);
    List<Peminjaman> getPeminjamans();
}
