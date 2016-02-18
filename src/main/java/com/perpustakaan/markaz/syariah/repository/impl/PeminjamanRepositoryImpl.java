package com.perpustakaan.markaz.syariah.repository.impl;

import com.perpustakaan.markaz.syariah.domain.Peminjaman;
import com.perpustakaan.markaz.syariah.repository.PeminjamanRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rizki on 27/06/15.
 */

@Repository
public class PeminjamanRepositoryImpl implements PeminjamanRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Peminjaman peminjaman) {
        sessionFactory.getCurrentSession().save(peminjaman);
    }

    @Override
    public void delete(String idPeminjaman) {
        sessionFactory.getCurrentSession().createQuery("delete from Peminjaman p where p.idPeminjaman = :idPeminjaman")
        .setParameter("idPeminjaman", idPeminjaman).executeUpdate();
    }

    @Override
    public Peminjaman getPeminjaman(String idPeminjaman) {
        return (Peminjaman) sessionFactory.getCurrentSession().get(Peminjaman.class, idPeminjaman);
    }

    @Override
    public List<Peminjaman> getPeminjamans() {
        return sessionFactory.getCurrentSession().createCriteria(Peminjaman.class).list();
    }
}
