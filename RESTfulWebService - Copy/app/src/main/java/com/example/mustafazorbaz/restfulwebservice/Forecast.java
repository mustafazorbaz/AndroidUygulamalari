
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
    "code",
    "date",
    "day",
    "high",
    "low",
    "text"
})
public class Forecast {

    @JsonProperty("code")
    private String code;
    @JsonProperty("date")
    private String date;
    @JsonProperty("day")
    private String day;
    @JsonProperty("high")
    private String high;
    @JsonProperty("low")
    private String low;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Forecast() {
    }

    /**
     * 
     * @param text
     * @param high
     * @param day
     * @param code
     * @param low
     * @param date
     */
    public Forecast(String code, String date, String day, String high, String low, String text) {
        this.code = code;
        this.date = date;
        this.day = day;
        this.high = high;
        this.low = low;
        this.text = text;
    }

    /**
     * 
     * @return
     *     The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The day
     */
    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * 
     * @return
     *     The high
     */
    @JsonProperty("high")
    public String getHigh() {
        return high;
    }

    /**
     * 
     * @param high
     *     The high
     */
    @JsonProperty("high")
    public void setHigh(String high) {
        this.high = high;
    }

    /**
     * 
     * @return
     *     The low
     */
    @JsonProperty("low")
    public String getLow() {
        return low;
    }

    /**
     * 
     * @param low
     *     The low
     */
    @JsonProperty("low")
    public void setLow(String low) {
        this.low = low;
    }

    /**
     * 
     * @return
     *     The text
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
