package com.jad.show;

class CreateMovieShowHandler extends CreateShowHandler {
    private static final String SHOW_DIRECTOR_KEY = "director";
    private static final String SHOW_YEAR_OF_RELEASE_KEY = "yearOfRelease";
    private static final String SHOW_MOVIE_TYPE_KEY = "movieType";

    public CreateMovieShowHandler() {
        super(ShowType.MOVIE);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (this.getShowTypeHandled() == this.getShowType(showDescription)) {
            return this.createMovieShow(showDescription);
        } else {
            return this.getNextHandler().handle(showDescription);
        }
    }

    private IShow createMovieShow(final String showDescription) throws IllegalArgumentException {
        return ShowFactory.makeMovieShow(
                this.getShowName(showDescription),
                this.getShowDescription(showDescription),
                this.getDirector(showDescription),
                this.getYearOfRelease(showDescription),
                this.getMovieType(showDescription));
    }

    private String getDirector(final String showDescription) throws IllegalArgumentException {
        return this.getShowParameterByKey(showDescription, CreateMovieShowHandler.SHOW_DIRECTOR_KEY);
    }

    private String getYearOfRelease(final String showDescription) throws IllegalArgumentException {
        return this.getShowParameterByKey(showDescription, CreateMovieShowHandler.SHOW_YEAR_OF_RELEASE_KEY);
    }

    private MovieType getMovieType(final String showDescription) throws IllegalArgumentException {
        final String stringMovieType = this.getShowParameterByKey(showDescription, CreateMovieShowHandler.SHOW_MOVIE_TYPE_KEY);
        if (stringMovieType == null) {
            throw new IllegalArgumentException("Movie type is not specified");
        }
        return MovieType.valueOf(stringMovieType);
    }
}
