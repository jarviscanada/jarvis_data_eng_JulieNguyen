package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.*;

public class TwitterDao implements CrdDao<Tweet, String>{

    private static final String API_BASE_URL = "https://api.twitter.com";
    private static final String POST_PATH = "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH = "/1.1/statuses/destroy";

    private static final String QUERY_SYM = "?";
    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";

    private static final int HTTP_OK = 200;

    private HttpHelper httpHelper;

    @Autowired
    public TwitterDao(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public Tweet create(Tweet entity) {

        URI uri;
        try{
            uri = getPostUri(tweet);
        }
        catch(URISyntaxException | UnsupportedEncodingException e){
            throw new IllegalArgumentException("Invalid tweet input", e);
        }
        HttpResponse response = httpHelper.httpPost(uri);

        return parseResponseBody(response, HTTP_OK);
    }

    private Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode){
        Tweet tweet = null;

        //Check response status
        int status = response.getStatusLine().getStatusCode();
        if (status != expectedStatusCode){
            try{
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
            catch(IOException e){
                System.out.println("Response has no entity");
            }
            throw new RuntimeException("Unexpected HTTP status: "+status);
        }

        if(response.getEntity()==null){
            throw new RuntimeException("Empty response body");
        }

        String jsonStr;
        try{
            jsonStr = EntityUtils.toString(response.getEntity());
        }
        catch(IOException e){
            throw new RuntimeException("Failed to convert entity to String", e);
        }

        try{
            tweet = JsonParser.toObjectFromJson(jsonStr, Tweet.class);
        }
        catch(IOException e){
            throw new RuntimeException("Unable to convert JSON str to Object", e);
        }

        return tweet;
    }

    @Override
    public Tweet findById(String s) {
        return null;
    }

    @Override
    public Tweet deleteById(String s) {
        return null;
    }
}
