package com.perpustakaan.markaz.syariah.repository.impl;

import com.perpustakaan.markaz.syariah.domain.Tulisan;
import com.perpustakaan.markaz.syariah.repository.TulisanRepository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */

@Repository
public class TulisanRepositoryImpl implements TulisanRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Tulisan tulisan) {
        sessionFactory.getCurrentSession().save(tulisan);
    }

    @Override
    public void update(Tulisan tulisan) {
        sessionFactory.getCurrentSession().update(tulisan);
    }

    @Override
    public void delete(Tulisan tulisan) {
        sessionFactory.getCurrentSession().delete(tulisan);
    }

    @Override
    public Tulisan getTulisan(String idTulisan) {
        return (Tulisan) sessionFactory.getCurrentSession().get(Tulisan.class, idTulisan);
    }

    @Override
    public Tulisan getTulisanPublish() {
        return (Tulisan) sessionFactory.getCurrentSession().createCriteria(Tulisan.class).add(Restrictions.eq("publish", Boolean.TRUE)).list().get(0);
    }

    @Override
    public List<Tulisan> getTulisans() {
        return sessionFactory.getCurrentSession().createCriteria(Tulisan.class).list();
    }
}
