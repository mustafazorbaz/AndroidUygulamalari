
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
    "units",
    "title",
    "link",
    "description",
    "language",
    "lastBuildDate",
    "ttl",
    "location",
    "wind",
    "atmosphere",
    "astronomy",
    "image",
    "item"
})
public class Channel {

    @JsonProperty("units")
    private Units units;
    @JsonProperty("title")
    private String title;
    @JsonProperty("link")
    private String link;
    @JsonProperty("description")
    private String description;
    @JsonProperty("language")
    private String language;
    @JsonProperty("lastBuildDate")
    private String lastBuildDate;
    @JsonProperty("ttl")
    private String ttl;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("atmosphere")
    private Atmosphere atmosphere;
    @JsonProperty("astronomy")
    private Astronomy astronomy;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("item")
    private Item item;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Channel() {
    }

    /**
     * 
     * @param wind
     * @param location
     * @param link
     * @param atmosphere
     * @param image
     * @param ttl
     * @param astronomy
     * @param units
     * @param title
     * @param description
     * @param item
     * @param lastBuildDate
     * @param language
     */
    public Channel(Units units, String title, String link, String description, String language, String lastBuildDate, String ttl, Location location, Wind wind, Atmosphere atmosphere, Astronomy astronomy, Image image, Item item) {
        this.units = units;
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.lastBuildDate = lastBuildDate;
        this.ttl = ttl;
        this.location = location;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.astronomy = astronomy;
        this.image = image;
        this.item = item;
    }

    /**
     * 
     * @return
     *     The units
     */
    @JsonProperty("units")
    public Units getUnits() {
        return units;
    }

    /**
     * 
     * @param units
     *     The units
     */
    @JsonProperty("units")
    public void setUnits(Units units) {
        this.units = units;
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
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The language
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The lastBuildDate
     */
    @JsonProperty("lastBuildDate")
    public String getLastBuildDate() {
        return lastBuildDate;
    }

    /**
     * 
     * @param lastBuildDate
     *     The lastBuildDate
     */
    @JsonProperty("lastBuildDate")
    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    /**
     * 
     * @return
     *     The ttl
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    /**
     * 
     * @param ttl
     *     The ttl
     */
    @JsonProperty("ttl")
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    /**
     * 
     * @return
     *     The location
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The wind
     */
    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    /**
     * 
     * @param wind
     *     The wind
     */
    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * 
     * @return
     *     The atmosphere
     */
    @JsonProperty("atmosphere")
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     * 
     * @param atmosphere
     *     The atmosphere
     */
    @JsonProperty("atmosphere")
    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    /**
     * 
     * @return
     *     The astronomy
     */
    @JsonProperty("astronomy")
    public Astronomy getAstronomy() {
        return astronomy;
    }

    /**
     * 
     * @param astronomy
     *     The astronomy
     */
    @JsonProperty("astronomy")
    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    /**
     * 
     * @return
     *     The image
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The item
     */
    @JsonProperty("item")
    public Item getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    @JsonProperty("item")
    public void setItem(Item item) {
        this.item = item;
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
