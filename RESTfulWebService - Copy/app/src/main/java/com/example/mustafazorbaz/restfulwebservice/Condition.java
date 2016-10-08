
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
    "temp",
    "text"
})
public class Condition {

    @JsonProperty("code")
    private String code;
    @JsonProperty("date")
    private String date;
    @JsonProperty("temp")
    private String temp;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition() {
    }

    /**
     * 
     * @param text
     * @param temp
     * @param code
     * @param date
     */
    public Condition(String code, String date, String temp, String text) {
        this.code = code;
        this.date = date;
        this.temp = temp;
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
     *     The temp
     */
    @JsonProperty("temp")
    public String getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp
     *     The temp
     */
    @JsonProperty("temp")
    public void setTemp(String temp) {
        this.temp = temp;
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
