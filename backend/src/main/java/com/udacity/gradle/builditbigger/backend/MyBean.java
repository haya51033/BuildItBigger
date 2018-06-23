package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String joke;

    public MyBean(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }
}