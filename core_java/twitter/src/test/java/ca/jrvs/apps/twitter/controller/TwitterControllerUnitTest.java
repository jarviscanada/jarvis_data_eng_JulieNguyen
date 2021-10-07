package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.util.JsonUtil;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {
    @Mock
    Service service;

    @InjectMocks
    TwitterController controller;

    String text = "Hello!";
    float longitude = 10.1f;
    float latitude = 10.1f;

    @Before
    public void setUp() throws Exception {
        controller = new TwitterController(service);
    }

    @Test
    public void postTweet() throws IOException {
        Tweet testTweet = new Tweet();

        Coordinates coordinates = new Coordinates();
        float[]coords = {longitude, latitude};
        coordinates.setCoordinates(coords);
        testTweet.setCoordinates(coordinates);
        testTweet.setText(text);

        String [] missingArgs = {"post", "Hello!"};
        String [] missingLatArgs = {"post", "Hello!", "10.1"};
        String [] badLatArgs = {"post", "Hello!", "ABC:10.1"};

        when(service.postTweet(any())).thenReturn(testTweet);
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

        Tweet tweet = controller.postTweet(validArgs);

        assertEquals(text, tweet.getText());
        int epsilon =(int) Math.abs(longitude - tweet.getCoordinates().getCoordinates()[0]); //required for float testing
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0], epsilon);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1], epsilon);
    }

    @Test
    public void showTweet() {
        Tweet testTweet = new Tweet();

        Coordinates coordinates = new Coordinates();
        float[]coords = {longitude, latitude};
        coordinates.setCoordinates(coords);
        testTweet.setCoordinates(coordinates);
        testTweet.setText(text);
        testTweet.setId_str("1446172072154214407");

        String [] missingArgs = {"show", "1446172072154214407"};

        when(service.showTweet(any(), any())).thenReturn(testTweet);
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
        Tweet testTweet = new Tweet();

        Coordinates coordinates = new Coordinates();
        float[]coords = {longitude, latitude};
        coordinates.setCoordinates(coords);
        testTweet.setCoordinates(coordinates);
        testTweet.setText(text);
        testTweet.setId_str("1446172072154214407");

        List<Tweet> testTweets = new ArrayList<Tweet>();
        testTweets.add(testTweet);

        String [] missingArgs = {"delete"};

        when(service.deleteTweets(any())).thenReturn(testTweets);
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