package com.twitter.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
@Entity
@Table(name = "TWEETS")
public class TweetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false, unique = true)
    private Long id;
    
    @Column(name = "tweet_id", nullable = false, updatable = false, unique = true)
    private String tweetId;
    
    @Column(name = "message", nullable = false, updatable = true)
    private String message;
    
    @Column(name = "times_stamp")
    private LocalDateTime dateTimeCreated;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }
    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }
    public String getTweetId() {
        return tweetId;
    }
    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }
    
}