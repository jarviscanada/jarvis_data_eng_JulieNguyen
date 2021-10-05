package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
        "coordinates",
        "type"
})
public class Coordinates {

    @JsonProperty("coordinates")
    public int [] coordinates;
    @JsonProperty("type")
    public String type;

    @JsonGetter
    public int[] getCoordinates() {
        return coordinates;
    }

    @JsonSetter
    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    @JsonGetter
    public String getType() {
        return type;
    }

    @JsonSetter
    public void setType(String type) {
        this.type = type;
    }
}
