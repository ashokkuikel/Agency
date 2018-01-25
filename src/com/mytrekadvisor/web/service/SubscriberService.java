package com.mytrekadvisor.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrekadvisor.web.dao.Subscriber;
import com.mytrekadvisor.web.dao.SubscriberDAO;

@Service
public class SubscriberService {

	@Autowired
	private SubscriberDAO subscriberDao;
	
	public List<Subscriber> getAllSubscriber() {

		return subscriberDao.getAllSubscribers();
	}

	public Subscriber findById(int classID) {

		return subscriberDao.findById(classID);
	}

	public void saveSubscriber(Subscriber subscriber) {
		subscriberDao.createsubscriber(subscriber);
	}

	public void deleteSubscriber(String subscriberID) {
		subscriberDao.deleteSubscriber(subscriberID);
	}

	public void updateSubscriber(Subscriber subscriber) {
		subscriberDao.updateSubscriber(subscriber);
	}
	
	public Subscriber getSpecificSubscriber(int subscriberID) {
		return subscriberDao.findById(subscriberID);
	}	
}
