package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMention {

    @JsonProperty("name")
    public String name;
    @JsonProperty("indices")
    public int [] indices;
    @JsonProperty("screen_name")
    public String screenName;
    @JsonProperty("id")
    public long id;
    @JsonProperty("id_str")
    public String id_str;
}
