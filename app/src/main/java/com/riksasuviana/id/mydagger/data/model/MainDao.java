package com.riksasuviana.id.mydagger.data.model;

import java.util.List;

/**
 * Created by riksasuviana on 04/10/17.
 */

public class MainDao<T> {
    private String page;
    private int total_results;
    private int total_pages;
    private T results;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
