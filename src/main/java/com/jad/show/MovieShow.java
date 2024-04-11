package com.jad.show;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieShow extends Show {

    private final String director;
    private final String yearOfRelease;
    private final MovieType movieType;

    protected MovieShow(final String name, final String description, final String director, final String yearOfRelease, final MovieType movieType) {
        super(name, description, ShowType.MOVIE);
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.movieType = movieType;
    }

    public String getDirector() {
        return this.director;
    }

    public String getYearOfRelease() {
        return this.yearOfRelease;
    }

    public MovieType getMovieType() {
        return this.movieType;
    }

    public void present() {
        log.info("J'ai assisté au film " + this.getName() + " de " + this.getDirector() + " sorti en " + this.getYearOfRelease());
    }
}
