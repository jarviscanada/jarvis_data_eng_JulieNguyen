package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.JsonUtil;
import ca.jrvs.apps.twitter.util.TweetUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import junit.framework.TestCase;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.net.URI;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TwitterDaoIntTest extends TestCase {

    public TwitterDao dao;
    String hashtag = "#sample";
    String text = "@tos test8 " + hashtag;
    float longitude = 10.1f;
    float latitude = -10.1f;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        System.out.println(consumerKey+"|"+consumerSecret+"|"+accessToken+"|"+tokenSecret);
        //Create components
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);

        dao = new TwitterDao(httpHelper);
    }

    @Test
    public void testACreate() throws JsonProcessingException {
        Tweet postTweet = TweetUtil.buildTweet(text, longitude, latitude);
        System.out.println(JsonUtil.toJson(postTweet, true, false));

        Tweet tweet = dao.create(postTweet);
        System.out.println(JsonUtil.toJson(tweet, true, false));

        assertEquals(text, tweet.getText());
        assertNotNull(tweet.getCoordinates());
        assertEquals(2, tweet.getCoordinates().getCoordinates().length);
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0]);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1]);
        assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    }

    @Test
    public void testBFindById() throws JsonProcessingException {
        String id = "1445474141113503751";
        Tweet tweet = dao.findById(id);
        System.out.println(JsonUtil.toJson(tweet, true, false));

        assertEquals(text, tweet.getText());
        assertNotNull(tweet.getCoordinates());
        assertEquals(2, tweet.getCoordinates().getCoordinates().length);
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0]);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1]);
        assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    }

    @Test
    public void testCDeleteById() throws JsonProcessingException {
        String id = "1445474141113503751";
        Tweet tweet = dao.deleteById(id);
        System.out.println(JsonUtil.toJson(tweet, true, false));

        assertEquals(text, tweet.getText());
        assertNotNull(tweet.getCoordinates());
        assertEquals(2, tweet.getCoordinates().getCoordinates().length);
        assertEquals(longitude, tweet.getCoordinates().getCoordinates()[0]);
        assertEquals(latitude, tweet.getCoordinates().getCoordinates()[1]);
        assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    }
}