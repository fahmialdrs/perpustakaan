package com.perpustakaan.markaz.syariah.repository;

import com.perpustakaan.markaz.syariah.domain.Peminjaman;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */
public interface PeminjamanRepository {
    void save(Peminjaman peminjaman);
    void delete(String idPeminjaman);
    Peminjaman getPeminjaman(String idPeminjaman);
    List<Peminjaman> getPeminjamans();
}
