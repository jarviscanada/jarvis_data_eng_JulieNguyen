package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.JsonUtil;
import ca.jrvs.apps.twitter.util.TweetUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterServiceIntTest {

    public TwitterService service;
    String hashtag = "#sample";
    String text = "@tos test9 " + hashtag;
    String text2 = "@tos test5 " + hashtag;
    float longitude = 10.1f;
    float latitude = -10.1f;

    @Before
    public void setUp() throws Exception {
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        System.out.println(consumerKey+"|"+consumerSecret+"|"+accessToken+"|"+tokenSecret);
        //Create components
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        service = new TwitterService(new TwitterDao(httpHelper));
    }

    @Test
    public void testAPostTweet() throws JsonProcessingException {

        String invalidText = "Lorem ipsum dolor sit amet, consectetuer " +
                "adipiscing elit. Aenean commodo ligula eget dolor. " +
                "Aenean massa. Cum sociis natoque penatibus et magnis dis " +
                "parturient montes, nascetur ridiculus mus. Donec quam felis, " +
                "ultricies nec, pellentesque eu, pretium quis, sem. Nulla " +
                "consequat massa quis en"; //290 characters (10 over limit)
        float invalidLong = 200.0f;
        float invalidLat = -100f;

        Tweet badTxtTweet =  TweetUtil.buildTweet(invalidText, longitude, latitude);
        Tweet badLongTweet =  TweetUtil.buildTweet(text, invalidLong, latitude);
        Tweet badLatTweet =  TweetUtil.buildTweet(text, longitude, invalidLat);

        //invalid text test
        try{
            service.postTweet(badTxtTweet);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Tweet must be 280 characters or less.";
            assertEquals(expected, e.getMessage());
        }

        //invalid longitude test
        try{
            service.postTweet(badLongTweet);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Coordinates are out of range.";
            assertEquals(expected, e.getMessage());
        }

        //invalid latitude test
        try{
            service.postTweet(badLatTweet);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Coordinates are out of range.";
            assertEquals(expected, e.getMessage());
        }

        Tweet postTweet = TweetUtil.buildTweet(text, longitude, latitude);
        Tweet tweet = service.postTweet(postTweet);

        //testing valid tweet
        assertEquals(text, tweet.getText());
        int epsilon =(int) Math.abs(longitude - tweet.getCoordinates().getCoordinates()[0]); //required for float testing
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0], epsilon);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1], epsilon);
        assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    }

    @Test
    public void testBShowTweet() throws JsonProcessingException {
        String id = "1445814382668091394";
        String invalidId = "ABC1234ABCDEFG%&*#JKLMN";
        String[] fields = {
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
        String[] invalidFields = {
                "created_at",
                "id",
                "id_str",
                "favorite_count",
                "favorited",
                "retweeted"
        };

        //invalid id testing
        try{
            service.showTweet(invalidId, fields);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "ID must be numerical characters.";
            assertEquals(expected, e.getMessage());
        }

        //invalid field testing
        try{
            service.showTweet(id, invalidFields);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "Invalid or Missing Fields(s): text entities coordinates retweet_count ";
            assertEquals(expected, e.getMessage());
        }

        Tweet tweet = service.showTweet(id, fields);

        assertEquals(text, tweet.getText());
        int epsilon =(int) Math.abs(longitude - tweet.getCoordinates().getCoordinates()[0]);
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0], epsilon);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1], epsilon);
        assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    }

    @Test
    public void testCDeleteById() throws JsonProcessingException {
        String[] ids = {"1445454948389429253", "1445455964530823179"};
        String[] invalidIds = {"ABC1234ABCDEFG%&*#JKLMN", "1445814382668091394"};
        List<Tweet> tweets = service.deleteTweets(ids);

        //invalid id testing
        try{
            service.deleteTweets(invalidIds);
            fail();
        }
        catch(IllegalArgumentException e){
            final String expected = "ID must be numerical characters.";
            assertEquals(expected, e.getMessage());
        }

        for(Tweet tweet : tweets) {
            assertTrue((text.equals(tweet.getText())) || text2.equals(tweet.getText()));
            int epsilon = (int) Math.abs(longitude - tweet.getCoordinates().getCoordinates()[0]);
            assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0], epsilon);
            assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1], epsilon);
            assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
        }
    }
}