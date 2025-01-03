package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class DaoFactory {
    public static GenericDao<Seller> createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static GenericDao<Department> createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
