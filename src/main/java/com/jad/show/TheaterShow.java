package com.jad.show;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TheaterShow extends Show {

    private final String director;
    private final ArrayList<String> actors = new ArrayList<>();

    protected TheaterShow(final String name, final String description, final String director, final String... actors) {
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

    @Override
    public void present() {
        log.info("J'ai assisté à la pièce de théâtre " + this.getName() + " de " + this.getDirector() + ". Il y avait : " + String.join(", ", this.getActors()));
    }
}
