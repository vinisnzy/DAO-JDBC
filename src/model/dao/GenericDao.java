package model.dao;

import java.util.List;

public interface GenericDao<T> {
    void insert(T department);

    void update(T department);

    void deleteById(Integer id);

    T findById(Integer id);

    List<T> findAll();
}
