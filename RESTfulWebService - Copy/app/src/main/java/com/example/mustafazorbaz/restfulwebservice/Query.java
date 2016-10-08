
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
    "count",
    "created",
    "lang",
    "results"
})
public class Query {

    @JsonProperty("count")
    private int count;
    @JsonProperty("created")
    private String created;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("results")
    private Results results;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public Query() {
    }
    public Query(int count, String created, String lang, Results results) {
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }
    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(int count) {
        this.count = count;
    }
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }
    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }
    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }
    @JsonProperty("results")
    public Results getResults() {
        return results;
    }
    @JsonProperty("results")
    public void setResults(Results results) {
        this.results = results;
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
