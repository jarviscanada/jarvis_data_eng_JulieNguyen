package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
        "text",
        "indices"
})
public class Hashtag {

    @JsonProperty("text")
    public String text;
    @JsonProperty("indices")
    public int [] indices;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }
}
