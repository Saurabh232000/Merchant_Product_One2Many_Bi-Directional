package org.jsp.Dao;

import java.util.List;

import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Entity.Merchant;

public class MerchantDao {
	Persistence persistence = new Persistence();
	EntityManager manager = persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction tx = manager.getTransaction();

	public Merchant saveMerchant(Merchant merchant) {
		manager.persist(merchant);
		tx.begin();
		tx.commit();
		return merchant;
	}

	public Merchant updateMerchant(Merchant merchant) {
		manager.merge(merchant);
		tx.begin();
		tx.commit();
		return merchant;
	}

	public Merchant findMerchantById(int id) {
		return manager.find(Merchant.class, id);
	}

	public List<Merchant> allMerchant() {
		String query = "select m from Merchant m";
		Query query1 = manager.createQuery(query);
		List resultList = query1.getResultList();
		return resultList;
	}

	public void deleteByMerchantId(int id) {
		Merchant find = manager.find(Merchant.class, id);
		if (find != null)
			manager.remove(find);
		tx.begin();
		tx.commit();
	}
}
