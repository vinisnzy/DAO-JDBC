package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface GenericDao<T> {
    void insert(T seller);

    void update(T seller);

    void deleteById(Integer id);

    T findById(Integer id);

    List<T> findAll();

    List<Seller> findByDepartment(Department department);
}
