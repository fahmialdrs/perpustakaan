package com.perpustakaan.markaz.syariah.service.impl;

import com.perpustakaan.markaz.syariah.domain.Buku;
import com.perpustakaan.markaz.syariah.domain.Peminjaman;
import com.perpustakaan.markaz.syariah.repository.BukuRepository;
import com.perpustakaan.markaz.syariah.repository.PeminjamanRepository;
import com.perpustakaan.markaz.syariah.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */

@Service
@Transactional(readOnly = true)
public class PeminjamanServiceImpl implements PeminjamanService{

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private BukuRepository bukuRepository;

    @Transactional
    @Override
    public void save(Peminjaman peminjaman, String noKode) {
        Buku buku = bukuRepository.getBuku(noKode);
        peminjaman.setBuku(buku);
        peminjamanRepository.save(peminjaman);
    }

    @Transactional
    @Override
    public void delete(String idPeminjaman) {
        peminjamanRepository.delete(idPeminjaman);
    }

    @Override
    public Peminjaman getPeminjaman(String idPeminjaman) {
        return peminjamanRepository.getPeminjaman(idPeminjaman);
    }

    @Override
    public List<Peminjaman> getPeminjamans() {
        return peminjamanRepository.getPeminjamans();
    }
}
