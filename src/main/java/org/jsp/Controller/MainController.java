package org.jsp.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.Dao.MerchantDao;
import org.jsp.Dao.ProductDao;
import org.jsp.Entity.Merchant;
import org.jsp.Entity.Product;

public class MainController {
	public static void main(String[] args) {
//  Persistence persistence = new Persistence();
//  EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
//  System.out.println(manager);
		MerchantDao dao = new MerchantDao();
		ProductDao dao1 = new ProductDao();
		boolean b = true;
		while (true) {
			System.out.println("Enter 1 for save Merchant");
			System.out.println("Enter 2 for update Merchant");
			System.out.println("Enter 3 for  findMerchantById");
			System.out.println("Enter 4 for findAllMerchant");
			System.out.println("Enter 5 for deleteMerchantById");
			System.out.println("Enter 6 for save Product By MerchantId");
			System.out.println("Enter 7 for update product By Merchant Id");
			System.out.println("Enter 8 for  findProductMerchantId:: QNeed.. ::");
			System.out.println("Enter 9 for findAllProduct");
			System.out.println("Enter 10 for deleteProductByMerchantId");
			System.out.println("Enter 11 for  findProductMerchantName:: QNeed.. ::");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Merchant m = new Merchant();
				System.out.println(" Enter Merchant name");
				m.setName(sc.next());
				System.out.println(" Enter Merchant Email");
				m.setEmail(sc.next());
				System.out.println(" Enter Merchant password");
				m.setPassword(sc.next());
				System.out.println(" Enter Merchant phone");
				m.setPhone(sc.nextLong());

				Product p1 = new Product();
				System.out.println(" Enter Product name");
				p1.setName(sc.next());
				System.out.println(" Enter Product price");
				p1.setPrice(sc.nextLong());
				p1.setMerchant(m);

				Product p2 = new Product();
				System.out.println(" Enter Product name");
				p2.setName(sc.next());
				System.out.println(" Enter Product price");
				p2.setPrice(sc.nextLong());
				p2.setMerchant(m);

				m.setProduct(Arrays.asList(p1, p2));
				dao.saveMerchant(m);
				break;
			case 2:
				Merchant m1 = new Merchant();
				System.out.println(" enter merchant Id to update");
				m1.setId(sc.nextInt());
				System.out.println(" enter Merchant name");
				m1.setName(sc.next());
				System.out.println("enter merchant email");
				m1.setEmail(sc.next());
				System.out.println(" enter merchant password");
				m1.setPassword(sc.next());
				System.out.println(" Enter merchant phone");
				m1.setPhone(sc.nextLong());
//
//			Product p3 = new Product();
//			p3.setId(8);
//			p3.setName("Dry Weed");
//			p3.setPrice(1200);
//			p3.setMerchant(m1);
//
//			m1.setProduct(Arrays.asList(p3));
				dao.updateMerchant(m1);
				break;
			case 3:
				System.out.println(" ENter merchant id to find");
				int id = sc.nextInt();
				Merchant find = dao.findMerchantById(id);
				if (find != null) {
					System.out.println(find.getId());
					System.out.println(find.getName());
					System.out.println(find.getPhone());
					System.out.println(find.getEmail());
					System.out.println(find.getPassword());
//					System.out.println(find.getProduct());
					/* If You Want To Print Merchant Detail Along With Product */
					for (Product p : find.getProduct()) {
						System.out.println(p.getId());
						System.out.println(p.getName());
						System.out.println(p.getPrice());
					}
				} else {
					System.err.println(" Invalid Merchant Id:");
				}
				break;
			case 4:
				List<Merchant> allMerchant = dao.allMerchant();
				for (Merchant data : allMerchant) {
					System.out.println(data.getId());
					System.out.println(data.getName());
					System.out.println(data.getEmail());
					System.out.println(data.getPassword());
					System.out.println(data.getPhone());
//					System.out.println(data.getProduct());
					/* If You Want To Print Merchant Detail Along With Product */
					for (Product p : data.getProduct()) {
						System.out.println(p.getId());
						System.out.println(p.getName());
						System.out.println(p.getPrice());
					}
				}
				break;
			case 5:
				System.out.println(" Enter merchant id to delete ");
				int id1 = sc.nextInt();
				dao.deleteByMerchantId(id1);
				System.out.println(" Merchant deleted seccessfully");
				break;
			case 6:
				Product p = new Product();
				System.out.println("Enter Merchant id to save Product:");
				int mid = sc.nextInt();
				System.out.println("Enter Product NAme:");
				p.setName(sc.next());
				System.out.println(" Enter Product price:");
				p.setPrice(sc.nextLong());
				Product sp = dao1.saveProductByMerchantId(p, mid);
				System.out.println(sp.getId());
				System.out.println(sp.getName());
				System.out.println(sp.getPrice());
				System.out.println(sp.getMerchant().getId());
				System.out.println(sp.getMerchant().getName());
				System.out.println(sp.getMerchant().getEmail());
				System.out.println(sp.getMerchant().getPassword());
				System.out.println(sp.getMerchant().getPhone());
				break;
			case 7:
				Product pu = new Product();
				System.out.println(" Enter merchant  id to update product");
				int mid1 = sc.nextInt();
				System.out.println(" Enter product id");
				pu.setId(sc.nextInt());
				System.out.println(" Enter product Name");
				pu.setName(sc.next());
				System.out.println(" Enter product price");
				pu.setPrice(sc.nextLong());
				Product up = dao1.updateProductByMerchantId(pu, mid1);
				System.out.println(up.getId());
				System.out.println(up.getName());
				System.out.println(up.getPrice());
				System.out.println(up.getMerchant().getId());
				System.out.println(up.getMerchant().getName());
				System.out.println(up.getMerchant().getEmail());
				System.out.println(up.getMerchant().getPassword());
				System.out.println(up.getMerchant().getPhone());
				break;
			case 8:
				System.out.println(" enter merchant id to get product");
				int mid3 = sc.nextInt();
				List<Product> gm = dao1.getproductByMerchantId(mid3);
				for (Product pe : gm) {
					System.out.println(pe.getId());
					System.out.println(pe.getName());
					System.out.println(pe.getPrice());
					System.out.println(pe.getMerchant().getId() + " " + pe.getMerchant().getName() + " "
							+ pe.getMerchant().getEmail() + " " + pe.getMerchant().getPassword() + " "
							+ pe.getMerchant().getPhone());
				}
				break;
			case 9:
				List<Product> allProduct = dao1.getAllProduct();
				for (Product pel : allProduct) {
					System.out.println(pel.getId());
					System.out.println(pel.getName());
					System.out.println(pel.getPrice());
					System.out.println(pel.getMerchant().getId());
				}
				break;
			case 10:
				System.out.println(" enter merchant id to delete Product: ");
				int mid4 = sc.nextInt();
				dao1.deleteProductByMerchantId(mid4);
				System.out.println("Deleted Successfully..........");
				break;
			case 11:
				System.out.println(" enter merchant name to get product");
				String mName = sc.next();
				List<Product> byMerchantName = dao1.getproductByMerchantName(mName);
				for (Product pe : byMerchantName) {
					System.out.println(pe.getId());
					System.out.println(pe.getName());
					System.out.println(pe.getPrice());
					System.out.println(pe.getMerchant().getId() + " " + pe.getMerchant().getName() + " "
							+ pe.getMerchant().getEmail() + " " + pe.getMerchant().getPassword() + " "
							+ pe.getMerchant().getPhone());
				}
				break;
			default:
				b = false;
			}
		}
	}
}
