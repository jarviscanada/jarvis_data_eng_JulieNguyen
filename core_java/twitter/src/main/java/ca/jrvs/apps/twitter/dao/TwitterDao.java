package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.model.Tweet;

public class TwitterDao implements CrdDao<Tweet, String>{

    private static final String API_BASE_URL = "https://api.twitter.com";
    private static final String POST_PATH = "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH = "/1.1/statuses/destroy";

    private static final String QUERY_SYM = "?";
    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";

    private static final int HTTP_OK = 200;

    @Override
    public Tweet create(Tweet entity) {
        return null;
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
