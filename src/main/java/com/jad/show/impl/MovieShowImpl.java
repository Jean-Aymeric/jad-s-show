package com.jad.show.impl;

import com.jad.show.MovieType;
import com.jad.show.ShowType;

public class MovieShowImpl extends ShowImpl {
    private final String director;
    private final String yearOfRelease;
    private final MovieType movieType;

    public MovieShowImpl(final String name, final String description, final String director, final String yearOfRelease, final MovieType movieType) {
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
}
