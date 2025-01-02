package application;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        GenericDao<Seller> sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);

        System.out.println("===== TEST 1: seller findById =====");
        System.out.println(seller);
        System.out.println();

        System.out.println("===== TEST 2: seller findByDepartment =====");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for (Seller s : list) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("===== TEST 3: seller findAll =====");
        list = sellerDao.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }
    }
}