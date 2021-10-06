package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwitterService implements Service{

    private CrdDao dao;

    private static final int TWEET_LIMIT = 280;
    private static final float LONG_MIN = -180;
    private static final float LONG_MAX = 180;
    private static final float LAT_MIN = -90;
    private static final float LAT_MAX = 90;

    public TwitterService(CrdDao dao) {
        this.dao = dao;
    }

    @Override
    public Tweet postTweet(Tweet tweet){
        validatePostTweet(tweet);
        return (Tweet) dao.create(tweet);
    }

    @Override
    public Tweet showTweet(String id, String[] fields){
        validateShowTweet(id, fields);
        return (Tweet) dao.findById(id);
    }

    @Override
    public List<Tweet> deleteTweets(String[] ids){
        for(String id : ids){
            validateId(id);
        }

        List<Tweet> deletedTweets = new ArrayList<Tweet>();
        for(String id : ids){
            deletedTweets.add((Tweet)dao.deleteById(id));
        }

        return deletedTweets;
    }

    public void validateShowTweet(String id, String[] fields){
        String[] validFields = {
                "created_at",
                "id",
                "id_str",
                "text",
                "entities",
                "coordinates",
                "retweet_count",
                "favorite_count",
                "favorited",
                "retweeted"
        };

        validateId(id);

        if(fields!=null) {
            ArrayList<String> fieldsList = new ArrayList(Arrays.asList(fields));
            ArrayList<String> invalidFields = new ArrayList(Arrays.asList(validFields));
            invalidFields.removeAll(fieldsList);
            if(invalidFields.size()!=0){
                String exceptionMessage = "Invalid or Missing Fields(s): ";
                for(String field : invalidFields){
                    exceptionMessage += field + " ";
                }
                throw new IllegalArgumentException(exceptionMessage);
            }
        }
    }



    public void validateId(String id){
        if(!id.matches("[0-9]+")){
            throw new IllegalArgumentException("ID must be numerical characters.");
        }
    }

    public void validatePostTweet(Tweet tweet){

        float [] coordinates = tweet.getCoordinates().getCoordinates();

        if(tweet.getText().length()>=TWEET_LIMIT){
            throw new IllegalArgumentException("Tweet must be 280 characters or less.");
        }
        else if(coordinates[0] > LONG_MAX || coordinates[0] < LONG_MIN ||
            coordinates[1] > LAT_MAX || coordinates[1] < LAT_MIN){
            throw new IllegalArgumentException("Coordinates are out of range.");
        }

    }

}
