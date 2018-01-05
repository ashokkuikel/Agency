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
@Component("postDao")
public class PostDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void create(Post post) {

		Transaction trans = session().beginTransaction();
		session().save(post);
		trans.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Post> getAllPosts() {

		Transaction trans = session().beginTransaction();
		List<Post> posts = session().createQuery("from Post").list();
		trans.commit();
		return posts;
	}

	public Post findById(int postID) {

		Transaction trans = session().beginTransaction();
		Post post = (Post) session().get(Post.class, postID);
		trans.commit();
		return post;
	}

	public void deletePost(String postID) {
		Transaction trans = session().beginTransaction();
		Query query = session().createQuery("delete from Post where id = :postID");
		query.setString("postID", postID);
		query.executeUpdate();
		trans.commit();
	}

	public void updatePost(Post post) {

		Transaction trans = session().beginTransaction();
		session().saveOrUpdate(post);
		trans.commit();
	}


}
