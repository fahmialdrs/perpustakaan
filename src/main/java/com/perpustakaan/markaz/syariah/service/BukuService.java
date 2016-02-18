package com.perpustakaan.markaz.syariah.service;

import com.perpustakaan.markaz.syariah.domain.Buku;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */
public interface BukuService {
    void save(Buku buku);
    void update(Buku buku);
    void delete(Buku buku);
    Buku getBuku(String noKode);
    List<Buku> searchBuku(String key, String value);
    List<Buku> getBukus();
}
