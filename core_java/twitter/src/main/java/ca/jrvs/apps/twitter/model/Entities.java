package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entities {

    @JsonProperty("hashtags")
    public Hashtag hashtags;
    @JsonProperty("user_mentions")
    public UserMention userMentions;
    @JsonProperty("coordinates")
    public Coordinates coordinates;
}
