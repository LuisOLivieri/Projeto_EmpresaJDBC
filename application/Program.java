package application;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.creatSellerDao();

        System.out.println("\n=== TEST 2: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
            for (Seller obj : list) {
                System.out.println(obj);
            }

        System.out.println("\n=== TEST 3: seller findAll ====");
            list = sellerDao.findAll();
            for (Seller obj : list) {
                System.out.println(obj);
            }

        System.out.println("\n=== TEST 4: seller findByDepartment ====");
            Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
            sellerDao.insert(newSeller);
        System.out.println("Insered new ID = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ====");
        seller  = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("update");

        System.out.println("\n=== TEST 6: seller DELLET ====");
        System.out.println("ENTER ID FOR DELETE TESTE: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("DELETE COMPLETED");



                sc.close();
    }
}