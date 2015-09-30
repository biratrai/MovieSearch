package com.example.movie.optoromovie.domain.model;

import java.util.ArrayList;
import java.util.List;


public class MovieDbModel {

    private Integer page;
    private List<MovieModel> results = new ArrayList<>();
    private Integer total_pages;
    private Integer total_results;

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The results
     */
    public List<MovieModel> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<MovieModel> results) {
        this.results = results;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public Integer getTotalPages() {
        return total_pages;
    }

    /**
     *
     * @param totalPages
     * The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.total_pages = totalPages;
    }

    /**
     *
     * @return
     * The totalResults
     */
    public Integer getTotalResults() {
        return total_results;
    }

    /**
     *
     * @param totalResults
     * The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.total_results = totalResults;
    }
}


