package com.twitter.app;

import java.util.List;

import com.twitter.entities.TweetEntity;

public interface TwitterEJB {
	
	List<TweetEntity> findAll();
	
	void create(TweetEntity tweet);

}
