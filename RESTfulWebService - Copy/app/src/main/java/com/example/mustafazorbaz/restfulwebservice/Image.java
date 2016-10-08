
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
    "title",
    "width",
    "height",
    "link",
    "url"
})
public class Image {

    @JsonProperty("title")
    private String title;
    @JsonProperty("width")
    private String width;
    @JsonProperty("height")
    private String height;
    @JsonProperty("link")
    private String link;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param title
     * @param height
     * @param link
     * @param width
     * @param url
     */
    public Image(String title, String width, String height, String link, String url) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.link = link;
        this.url = url;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The width
     */
    @JsonProperty("width")
    public String getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    @JsonProperty("width")
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The height
     */
    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
