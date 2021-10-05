package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
        "hashtags",
        "user_mentions",
        "coordinates"
})
public class Entities {

    @JsonProperty("hashtags")
    public Hashtag hashtags;
    @JsonProperty("user_mentions")
    public UserMention userMentions;
    @JsonProperty("coordinates")
    public Coordinates coordinates;

    public Hashtag getHashtags() {
        return hashtags;
    }

    public void setHashtags(Hashtag hashtags) {
        this.hashtags = hashtags;
    }

    public UserMention getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(UserMention userMentions) {
        this.userMentions = userMentions;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
