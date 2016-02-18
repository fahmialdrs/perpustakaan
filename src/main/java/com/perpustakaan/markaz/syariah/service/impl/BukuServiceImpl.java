package com.perpustakaan.markaz.syariah.service.impl;

import com.perpustakaan.markaz.syariah.domain.Buku;
import com.perpustakaan.markaz.syariah.repository.BukuRepository;
import com.perpustakaan.markaz.syariah.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */

@Service
@Transactional(readOnly = true)
public class BukuServiceImpl implements BukuService{

    @Autowired
    private BukuRepository bukuRepository;

    @Transactional
    @Override
    public void save(Buku buku) {
        bukuRepository.save(buku);
    }

    @Transactional
    @Override
    public void update(Buku buku) {
        bukuRepository.update(buku);
    }

    @Transactional
    @Override
    public void delete(Buku buku) {
        bukuRepository.delete(buku);
    }

    @Override
    public Buku getBuku(String noKode) {
        return bukuRepository.getBuku(noKode);
    }

    @Override
    public List<Buku> searchBuku(String key, String value) {
        return bukuRepository.searchBuku(key, value);
    }

    @Override
    public List<Buku> getBukus() {
        return bukuRepository.getBukus();
    }
}
