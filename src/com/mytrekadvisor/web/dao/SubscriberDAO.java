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
@Component("subscriberDao")
public class SubscriberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void createsubscriber(Subscriber subscriber) {
		Transaction trans = session().beginTransaction();
		session().save(subscriber);
		trans.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Subscriber> getAllSubscribers() {

		Transaction trans = session().beginTransaction();
		List<Subscriber> subscribers = session().createQuery("from Subscriber").list();
		trans.commit();
		return subscribers;
	}

	public Subscriber findById(int subscriberID) {

		Transaction trans = session().beginTransaction();
		Subscriber subscriber = (Subscriber) session().get(Subscriber.class, subscriberID);
		trans.commit();
		return subscriber;
	}

	public void deleteSubscriber(String subscriberID) {
		Transaction trans = session().beginTransaction();
		Query query = session().createQuery("delete from Subscriber where id = :subscriberID");
		query.setString("subscriberID", subscriberID);
		query.executeUpdate();
		trans.commit();
	}

	public void updateSubscriber(Subscriber subscriber) {

		Transaction trans = session().beginTransaction();
		session().saveOrUpdate(subscriber);
		trans.commit();
	}


}
