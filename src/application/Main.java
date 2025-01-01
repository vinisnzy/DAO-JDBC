package application;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department department = new Department(1, "Computers");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, department);

        GenericDao<Seller> sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}