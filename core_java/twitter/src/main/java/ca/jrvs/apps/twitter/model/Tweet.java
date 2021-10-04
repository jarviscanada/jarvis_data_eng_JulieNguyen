package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {

    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("id")
    public long id;
    @JsonProperty("id_str")
    public String id_str;
    @JsonProperty("text")
    public String text;
    @JsonProperty("entities")
    public String entities;
    @JsonProperty("retweet_count")
    public int retweetCount;
    @JsonProperty("favorite_count")
    public int favoriteCount;
    @JsonProperty("favorited")
    public boolean favorited;
    @JsonProperty("retweeted")
    public boolean retweeted;

}
