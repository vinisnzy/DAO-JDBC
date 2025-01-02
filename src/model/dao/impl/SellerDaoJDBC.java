package model.dao.impl;

import db.DB;
import model.dao.GenericDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements GenericDao<Seller> {

    private final Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

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
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE seller.Id = ?"
            );

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Department department = instantiateDepartment(rs);
                return instantiateSeller(rs, department);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("DepartmentId"));
        department.setName(rs.getString("DepName"));
        return department;
    }

    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBirthDate(rs.getDate("BirthDate"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setDepartment(department);
        return seller;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
