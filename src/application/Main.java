package application;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        GenericDao<Seller> sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);

        System.out.println("===== TEST 1: seller findById =====");
        System.out.println(seller);
        System.out.println();

        System.out.println("===== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("===== TEST 3: seller findAll =====");
        list = sellerDao.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println("===== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 5000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());
    }
}