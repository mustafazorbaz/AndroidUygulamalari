
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
    "humidity",
    "pressure",
    "rising",
    "visibility"
})
public class Atmosphere {

    @JsonProperty("humidity")
    private String humidity;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("rising")
    private String rising;
    @JsonProperty("visibility")
    private String visibility;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Atmosphere() {
    }

    /**
     * 
     * @param rising
     * @param humidity
     * @param pressure
     * @param visibility
     */
    public Atmosphere(String humidity, String pressure, String rising, String visibility) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.rising = rising;
        this.visibility = visibility;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    @JsonProperty("humidity")
    public String getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    @JsonProperty("humidity")
    public void setHumidity(String humidity) {
        this.humidity = humidity;
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
     *     The rising
     */
    @JsonProperty("rising")
    public String getRising() {
        return rising;
    }

    /**
     * 
     * @param rising
     *     The rising
     */
    @JsonProperty("rising")
    public void setRising(String rising) {
        this.rising = rising;
    }

    /**
     * 
     * @return
     *     The visibility
     */
    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    /**
     * 
     * @param visibility
     *     The visibility
     */
    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
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
