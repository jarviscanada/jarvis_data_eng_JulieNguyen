package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {
    @JsonProperty("coordinates")
    public int [] coordinates;
    @JsonProperty("type")
    public String type;
}
