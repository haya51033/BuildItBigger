package com.example.android.javajokers;

import java.util.concurrent.ThreadLocalRandom;

public class JokerClass {
    private static final String[] JOKESArray = new String[]{
            "Joke 1",
            "Joke 2",
            "Joke 3",
            "Joke 4",
            "Joke 5"
    };

    public String createNewJoke() {
        final int randomNum = ThreadLocalRandom.current().nextInt(0, JOKESArray.length);
        return JOKESArray[randomNum];
    }
    public JokerClass(){}
}
