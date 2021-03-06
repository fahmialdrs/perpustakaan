package com.perpustakaan.markaz.syariah.repository;

import com.perpustakaan.markaz.syariah.domain.Tulisan;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */
public interface TulisanRepository {
    void save(Tulisan tulisan);
    void update(Tulisan tulisan);
    void delete(Tulisan tulisan);
    Tulisan getTulisan(String idTulisan);
    Tulisan getTulisanPublish();
    List<Tulisan> getTulisans();
}
