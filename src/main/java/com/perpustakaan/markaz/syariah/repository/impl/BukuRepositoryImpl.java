package com.perpustakaan.markaz.syariah.repository.impl;

import com.perpustakaan.markaz.syariah.domain.Buku;
import com.perpustakaan.markaz.syariah.repository.BukuRepository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */

@Repository
public class BukuRepositoryImpl implements BukuRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Buku buku) {
        sessionFactory.getCurrentSession().save(buku);
    }

    @Override
    public void update(Buku buku) {
        sessionFactory.getCurrentSession().update(buku);
    }

    @Override
    public void delete(Buku buku) {
        sessionFactory.getCurrentSession().delete(buku);
    }

    @Override
    public Buku getBuku(String noKode) {
        return (Buku) sessionFactory.getCurrentSession().get(Buku.class, noKode);
    }

    @Override
    public List<Buku> searchBuku(String key, String value) {
        return sessionFactory.getCurrentSession().createCriteria(Buku.class).add(Restrictions.like(key, value)).list();
    }

    @Override
    public List<Buku> getBukus() {
        return sessionFactory.getCurrentSession().createCriteria(Buku.class).list();
    }
}
