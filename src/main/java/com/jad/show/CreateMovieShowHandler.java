package com.jad.show;

import static com.jad.show.Helper.getDirector;
import static com.jad.show.Helper.getFieldValueByName;
import static com.jad.show.Helper.isShowType;

public class CreateMovieShowHandler extends CreateShowHandler {

    protected CreateMovieShowHandler() {}

    @Override
    public IShow handle(String showDescription) {
        if (isShowType(ShowType.MOVIE, showDescription)) {
            return new MovieShow(getName(showDescription),
                                 getDescription(showDescription),
                                 getDirector(showDescription),
                                 getYearOfRelease(showDescription),
                                 getMovieType(showDescription));
        }
        return getNextHandler().handle(showDescription);
    }

    private String getYearOfRelease(String showDescription) {
        return getFieldValueByName(showDescription, "yearOfRelease");
    }

    private MovieType getMovieType(String showDescription) {
        return MovieType.valueOf(getFieldValueByName(showDescription, "movieType"));
    }

}
