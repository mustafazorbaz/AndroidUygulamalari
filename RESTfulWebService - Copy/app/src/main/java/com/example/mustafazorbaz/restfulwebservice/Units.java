
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
    "distance",
    "pressure",
    "speed",
    "temperature"
})
public class Units {

    @JsonProperty("distance")
    private String distance;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("speed")
    private String speed;
    @JsonProperty("temperature")
    private String temperature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Units() {
    }

    /**
     * 
     * @param distance
     * @param pressure
     * @param speed
     * @param temperature
     */
    public Units(String distance, String pressure, String speed, String temperature) {
        this.distance = distance;
        this.pressure = pressure;
        this.speed = speed;
        this.temperature = temperature;
    }

    /**
     * 
     * @return
     *     The distance
     */
    @JsonProperty("distance")
    public String getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance
     *     The distance
     */
    @JsonProperty("distance")
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    @JsonProperty("pressure")
    public String getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    @JsonProperty("pressure")
    public void setPressure(String pressure) {
        this.pressure = pressure;
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

    /**
     * 
     * @return
     *     The temperature
     */
    @JsonProperty("temperature")
    public String getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */
    @JsonProperty("temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
