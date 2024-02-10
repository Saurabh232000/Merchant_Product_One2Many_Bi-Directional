package org.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Entity.Merchant;
import org.jsp.Entity.Product;

public class ProductDao {

	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction tx = manager.getTransaction();

	public Product saveProductByMerchantId(Product product, int id) {
		Merchant find = manager.find(Merchant.class, id);
		if (find != null) {
			product.setMerchant(find);
			find.getProduct().add(product);
			manager.persist(find);
			tx.begin();
			tx.commit();
			return product;
		}
		return null;
	}

	public Product updateProductByMerchantId(Product product, int id) {
		Merchant find = manager.find(Merchant.class, id);
		if (find != null) {
			product.setMerchant(find);
			find.getProduct().add(product);
			manager.merge(find);
			tx.begin();
			tx.commit();
			return product;
		}
		return null;
	}

	public List<Product> getproductByMerchantId(int id) {
		String qry = "select m.product from Merchant m where m.id=?1";
		Query query = manager.createQuery(qry);
		Query setParameter = query.setParameter(1, id);
		List resultList = query.getResultList();
		/// List<Product> resultList2 = setParameter.getResultList();
		return resultList;
	}

	public List<Product> getproductByMerchantName(String name) {
		String qry = "select m.product from Merchant m where m.name=?1";
		Query query = manager.createQuery(qry);
		Query setParameter = query.setParameter(1, name);
		List<Product> resultList = query.getResultList();
		return resultList;
	}

	public List<Product> getAllProduct() {
		String query = "select p from Product p";
		Query createQuery = manager.createQuery(query);
		List<Product> resultList = createQuery.getResultList();
		return resultList;
	}

	public void deleteProductByMerchantId(int id) {
		Merchant find = manager.find(Merchant.class, id);
		if (find != null) {
			manager.remove(find);
			tx.begin();
			tx.commit();
		}
	}
}
