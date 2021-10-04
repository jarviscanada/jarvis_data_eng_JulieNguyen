package ca.jrvs.apps.twitter.dao;

import junit.framework.TestCase;

public class TwitterHttpHelperTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
    }

    public void testHttpPost() {
    }

    public void testHttpGet() {
    }
}