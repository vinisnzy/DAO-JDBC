package application;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Seller;


public class Main {
    public static void main(String[] args) {

        GenericDao<Seller> sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);
        System.out.println("===== TEST 1: seller findById =====");
        System.out.println(seller);
    }
}