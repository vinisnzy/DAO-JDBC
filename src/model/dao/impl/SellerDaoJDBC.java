package model.dao.impl;

import model.dao.GenericDao;
import model.entities.Seller;

import java.util.List;

public class SellerDaoJDBC implements GenericDao<Seller> {

    @Override
    public void insert(Seller department) {

    }

    @Override
    public void update(Seller department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
