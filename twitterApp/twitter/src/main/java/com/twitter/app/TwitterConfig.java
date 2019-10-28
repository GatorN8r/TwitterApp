package com.twitter.app;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
public class TwitterConfig {
    
    private static TwitterConfig instance;
    
    private static Twitter twitterInstance;
    
    private TwitterConfig() {}
    private static Twitter twitterInstance() {
        
        if(twitterInstance != null) {
            return twitterInstance;
        }
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("LoHQi4wGta5vITknqaxBvBRqW")
          .setOAuthConsumerSecret("I6ItWzwgnK71ZicJh0AeVquV70D9wQdFHBx9Vnm0ZPvB9GybfS")
          .setOAuthAccessToken("273892273-08F2jS5O3DOF2f0YxWw7aDqKeD0MYgZKrTHvkuvR")
          .setOAuthAccessTokenSecret("OWIxg4tPlSmVhxI0ZXBd3x6pciS2jqY5dU045TMGPIuWa");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitterInstance = tf.getInstance();
        return twitterInstance;
        
    }
    
    
    public static Twitter getInstance() {
        
        if(instance == null) {
            instance = new TwitterConfig();
        }
        return twitterInstance();
    }
    
}
