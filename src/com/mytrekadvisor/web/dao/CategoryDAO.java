package com.mytrekadvisor.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("categoryDao")
public class CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}
		
	public void createCategory(Category category) {
			
		Transaction trans = session().beginTransaction();
		session().save(category);
		trans.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {

		Transaction trans = session().beginTransaction();
		List<Category> categories = session().createQuery("from Category").list();
		trans.commit();
		System.out.println(categories.size());
		return categories;
	}
	
	public Category findById(int categoryID) {
		
		Transaction trans = session().beginTransaction();
		Category category = (Category) session().get(Category.class, categoryID);
		trans.commit();
		return category;
	}
	
	public void deleteCategory(String categoryID) {
		Transaction trans = session().beginTransaction();
		Query query = session().createQuery("delete from Category where id = :categoryID");
		query.setString("categoryID", categoryID);
		query.executeUpdate();
		trans.commit();
	}
	
	public void updateCategory(Category category) {
		
		Transaction trans = session().beginTransaction();
		session().saveOrUpdate(category);
		trans.commit();
	}
	
	public Category getSpecificCategory(String categoryName) {
		
		Transaction trans = session().beginTransaction();
		String hql = "from Category c where c.name= :categoryName";
		Query q = session().createQuery(hql);
		q = q.setString("categoryName", categoryName);
		Category category= (Category) q.uniqueResult();
		trans.commit();
		return category;
	}
	
}
