package com.twitter.app;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.twitter.entities.TweetEntity;

import twitter4j.StatusUpdate;
import twitter4j.TwitterException;


@Path("/tweets")
public class TwitterController {
	@Inject
	TwitterEJB twitterEJB;

	@POST
    @Path("/update/status")
    @Produces("application/json")
    public String updateTweetStatus(String body) {
        
        String tweetId = UUID.randomUUID().toString();
        
        StatusUpdate statusUpdate = new StatusUpdate(body);
        statusUpdate.setPlaceId(tweetId);
        
        try {
            TwitterConfig.getInstance().updateStatus(statusUpdate);
            TweetEntity twitterModel = new TweetEntity();
            twitterModel.setMessage(body);
            twitterModel.setTweetId(tweetId);
            twitterModel.setDateTimeCreated(LocalDateTime.now());
            twitterEJB.create(twitterModel);
        } catch (TwitterException e) {
            return "Failed to update tweet status";
        }
        
        return "Tweet status successfully updated";
    }
    
	@GET
    @Produces("application/json")
    public List<TweetEntity> findAll() {
		return twitterEJB.findAll();
	}

	
}
