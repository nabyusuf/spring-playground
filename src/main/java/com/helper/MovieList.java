package com.helper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trainer3 on 4/30/17.
 */
public class MovieList {

    private ArrayList<Search> search;

    public ArrayList<Search> getSearch() { return this.search; }

    @JsonProperty(value = "Search")
    public void setSearch(ArrayList<Search> search) { this.search = search; }

    private String totalResults;

    @JsonIgnore
    public String getTotalResults() { return this.totalResults; }

    public void setTotalResults(String totalResults) { this.totalResults = totalResults; }

    private String response;

    @JsonIgnore
    public String getResponse() { return this.response; }

    @JsonProperty(value = "Response")
    public void setResponse(String response) { this.response = response; }
}
