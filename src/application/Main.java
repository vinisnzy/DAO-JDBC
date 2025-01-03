package application;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        System.out.println("===== TEST 5: seller update =====");
        seller = sellerDao.findById(1);
        seller.setName("Franciele Borges");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("===== TEST 6: seller delete =====");
        System.out.print("Enter id for delete test:");
        sellerDao.deleteById(sc.nextInt());
        System.out.println("Delete Completed");
    }
}