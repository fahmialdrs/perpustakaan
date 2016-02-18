package com.perpustakaan.markaz.syariah.service.impl;

import com.perpustakaan.markaz.syariah.domain.Tulisan;
import com.perpustakaan.markaz.syariah.repository.TulisanRepository;
import com.perpustakaan.markaz.syariah.service.TulisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */

@Service
@Transactional(readOnly = true)
public class TulisanServiceImpl implements TulisanService{

    @Autowired
    private TulisanRepository tulisanRepository;

    @Transactional
    @Override
    public void save(Tulisan tulisan) {
        tulisanRepository.save(tulisan);
    }

    @Transactional
    @Override
    public void update(Tulisan tulisan) {
        tulisanRepository.update(tulisan);
    }

    @Transactional
    @Override
    public void delete(Tulisan tulisan) {
        tulisanRepository.delete(tulisan);
    }

    @Override
    public Tulisan getTulisan(String idTulisan) {
        return tulisanRepository.getTulisan(idTulisan);
    }

    @Override
    public Tulisan getTulisanPublish() {
        return tulisanRepository.getTulisanPublish();
    }

    @Override
    public List<Tulisan> getTulisans() {
        return tulisanRepository.getTulisans();
    }
}
