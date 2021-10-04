package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hashtag {

    @JsonProperty("text")
    public String text;
    @JsonProperty("indices")
    public int [] indices;

}
