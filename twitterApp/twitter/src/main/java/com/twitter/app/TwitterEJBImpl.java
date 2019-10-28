package com.twitter.app;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.twitter.entities.TweetEntity;

@SuppressWarnings("unchecked")
@Stateless
public class TwitterEJBImpl implements TwitterEJB {
	
	@PersistenceContext
	EntityManager em;


	@Override
	public List<TweetEntity> findAll() {
		Query q = em.createQuery("FROM TweetEntity");
		return q.getResultList();
	}


	@Override
	public void create(TweetEntity tweet) {
		this.em.persist(tweet);
	}
}
