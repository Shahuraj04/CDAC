package com.ecom.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecom.entities.Category;
import com.ecom.entities.Product;

import static com.ecom.utils.EcommerceUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product) {

		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();

		// 2. Begin Transaction
		Transaction tx = session.beginTransaction();
		try {
			session.persist(product);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}
		return "Product Added Successfully!!!";
	}

	@Override
	public Product displayDetailsById(Long id) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Product product = null;
		try {
			product = session.find(Product.class, id);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return product;
	}
	/*
	 * 3. Display id , name , price of all the products manufactured before
	 * specified date and from specific category i/p - date , category(enum) o/p -
	 * List of selected products details
	 */

	@Override
	public List<Product> filterByDateAndCategory(String date, String category) {

		List<Product> prdList = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select new com.ecom.entities.Product(p.product_id,p.name,p.price) from Product p where p.date<:date2 and category=:category1";
		LocalDate date2 = LocalDate.parse(date);
		Category category1 = Category.valueOf(category);
		try {
			prdList = session.createQuery(jpql, Product.class).setParameter("date2", date2)
					.setParameter("category1", category1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;

		}

		return prdList;
	}

	@Override
	public String changePrice(String prdName, double price) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select p from Product p where name=:name";
		Product product = null;
		try {
			product = session.createQuery(jpql, Product.class).setParameter("name", prdName).getSingleResult();
			product.setPrice(price);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		if (product != null) {
			return product.toString();
		}
		return "Error";
	}

	@Override
	public String applyDiscount(int qty, double dicount) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		int rows=0;
		String jpql = "update Product p set p.price=p.price-price*:discount where quantity>:quantity";
		try {
		 rows = session.createMutationQuery(jpql).setParameter("discount", dicount).setParameter("quantity", qty)
					.executeUpdate();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		if(rows>0) {
			return "prices updated successfully";
		}
		return "error";
	}

}
