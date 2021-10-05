package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
        "name",
        "indices",
        "screen_name",
        "id",
        "id_str"
})
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }
}
