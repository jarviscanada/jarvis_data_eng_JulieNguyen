package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterControllerIntTest {

    public TwitterController controller;

    @Before
    public void setUp() throws Exception {
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        System.out.println(consumerKey+"|"+consumerSecret+"|"+accessToken+"|"+tokenSecret);

        //Create components
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        controller = new TwitterController(new TwitterService(new TwitterDao(httpHelper)));
    }

    @Test
    public void postTweet() {
        String [] missingArgs = {"post", "Hello!"};
        String [] missingLatArgs = {"post", "Hello!", "10.1"};
        String [] badLatArgs = {"post", "Hello!", "ABC:10.1"};

        try{
            controller.postTweet(missingArgs);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Invalid or " +
                    "Missing Arguments. Usage: TwitterApp \"post\" \"tweet_text\" \"latitude:longitude\"";
            assertEquals(expected, e.getMessage());
        }

        try{
            controller.postTweet(missingLatArgs);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Invalid number of coordinates. " +
                    "Usage: TwitterApp \"post\" \"tweet_text\" \"latitude:longitude\"";
            assertEquals(expected, e.getMessage());
        }

        try{
            controller.postTweet(badLatArgs);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Invalid coordinates (Must be float). " +
                    "Usage: TwitterApp \"post\" \"tweet_text\" \"latitude:longitude\"";
            assertEquals(expected, e.getMessage());
        }

        String [] validArgs = {"post", "Hello!", "10.1:10.1"};
        String text = "Hello!";
        float longitude = 10.1f;
        float latitude = 10.1f;
        Tweet tweet = controller.postTweet(validArgs);

        assertEquals(validArgs[1], tweet.getText());
        int epsilon =(int) Math.abs(longitude - tweet.getCoordinates().getCoordinates()[0]); //required for float testing
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0], epsilon);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1], epsilon);
    }

    @Test
    public void showTweet() {
        String [] missingArgs = {"show", "1446172072154214407"};
        try{
            controller.showTweet(missingArgs);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Invalid or " +
                    "Missing Arguments. Usage: TwitterApp show tweet_id \"field1,fields2\"";
            assertEquals(expected, e.getMessage());
        }

        String [] validArgs = {"show", "1446172072154214407", "id,text,coordinates"};
        Tweet tweet = controller.showTweet(validArgs);

        String text = "Hello!";
        float longitude = 10.1f;
        float latitude = 10.1f;

        assertEquals(text, tweet.getText());
        int epsilon =(int) Math.abs(longitude - tweet.getCoordinates().getCoordinates()[0]); //required for float testing
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0], epsilon);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1], epsilon);
    }

    @Test
    public void deleteTweet() {
        String [] missingArgs = {"delete"};
        try{
            controller.deleteTweet(missingArgs);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Invalid or " +
                    "Missing Arguments. Usage: TwitterApp delete \"id1,id2,..\"";
            assertEquals(expected, e.getMessage());
        }

        String [] validArgs = {"delete", "1446179603752669195"};
        List<Tweet> tweets = controller.deleteTweet(validArgs);

        String text = "Hello!";
        float longitude = 10.1f;
        float latitude = 10.1f;

        assertEquals(text, tweets.get(0).getText());
        int epsilon =(int) Math.abs(longitude - tweets.get(0).getCoordinates().getCoordinates()[0]); //required for float testing
        assertEquals(longitude, tweets.get(0).getCoordinates().getCoordinates()[0], epsilon);
        assertEquals(latitude, tweets.get(0).getCoordinates().getCoordinates()[1], epsilon);
    }
}