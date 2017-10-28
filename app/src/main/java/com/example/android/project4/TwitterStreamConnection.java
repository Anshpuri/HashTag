package com.example.android.project4;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by amandhapola on 08/07/17.
 */

public class TwitterStreamConnection {

    private ConfigurationBuilder cb;
    private TwitterStream twitterStream;

    public ConfigurationBuilder getCb() {
        return cb;
    }


    public TwitterStream getTwitterStream() {
        return twitterStream;
    }

    private static final TwitterStreamConnection ourInstance = new TwitterStreamConnection();

    public static TwitterStreamConnection getInstance() {
        return ourInstance;
    }

    private TwitterStreamConnection() {
        cb=new ConfigurationBuilder();
        cb.setOAuthConsumerKey("JRpQO5CwsYS7oRZAIurfuCqWP")
                .setOAuthConsumerSecret("Pw2qpet2tzSFOcnWGeC3NSt9RwXOqbgEk9wiBMmimSl1I6th8u")
                .setOAuthAccessToken("156889059-FSoiwUeokl4mOIaGqpZWYFobNp2FzJ0ufJfuly4K")
                .setOAuthAccessTokenSecret("Q8nE9dYPTYZkzg1Pyam0kCCJCi1bmSMpx0axvjjSOxU2k");

        twitterStream=new TwitterStreamFactory(cb.build()).getInstance();
    }
}
