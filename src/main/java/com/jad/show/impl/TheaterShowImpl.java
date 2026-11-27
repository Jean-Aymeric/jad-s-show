package com.jad.show.impl;

import com.jad.show.ShowType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheaterShowImpl extends ShowImpl {
    private final String director;
    private final ArrayList<String> actors = new ArrayList<>();

    public TheaterShowImpl(final String name, final String description, final String director, final String... actors) {
        super(name, description, ShowType.THEATER);
        this.director = director;
        this.actors.addAll(Arrays.asList(actors));
    }

    public String getDirector() {
        return this.director;
    }

    public List<String> getActors() {
        return Collections.unmodifiableList(this.actors);
    }
}
