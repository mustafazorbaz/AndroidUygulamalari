
package com.example.mustafazorbaz.restfulwebservice;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "chill",
    "direction",
    "speed"
})
public class Wind {

    @JsonProperty("chill")
    private String chill;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("speed")
    private String speed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Wind() {
    }

    /**
     * 
     * @param speed
     * @param direction
     * @param chill
     */
    public Wind(String chill, String direction, String speed) {
        this.chill = chill;
        this.direction = direction;
        this.speed = speed;
    }

    /**
     * 
     * @return
     *     The chill
     */
    @JsonProperty("chill")
    public String getChill() {
        return chill;
    }

    /**
     * 
     * @param chill
     *     The chill
     */
    @JsonProperty("chill")
    public void setChill(String chill) {
        this.chill = chill;
    }

    /**
     * 
     * @return
     *     The direction
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * 
     * @param direction
     *     The direction
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * 
     * @return
     *     The speed
     */
    @JsonProperty("speed")
    public String getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */
    @JsonProperty("speed")
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
