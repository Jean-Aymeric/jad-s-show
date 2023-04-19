package com.jad.show;

class CreateTheaterShowHandler extends CreateShowHandler {
    public static final String SHOW_ACTORS_SEPARATOR = ",";
    private static final String SHOW_DIRECTOR_KEY = "director";
    private static final String SHOW_ACTORS_KEY = "actors";

    public CreateTheaterShowHandler() {
        super(ShowType.THEATER);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (this.getShowTypeHandled() == this.getShowType(showDescription)) {
            return this.createTheaterShow(showDescription);
        } else {
            return this.getNextHandler().handle(showDescription);
        }
    }

    private IShow createTheaterShow(final String showDescription) throws IllegalArgumentException {
        return ShowFactory.makeTheaterShow(
                this.getShowName(showDescription),
                this.getShowDescription(showDescription),
                this.getDirector(showDescription),
                this.getActors(showDescription));
    }

    private String getDirector(final String showDescription) throws IllegalArgumentException {
        return this.getShowParameterByKey(showDescription, CreateTheaterShowHandler.SHOW_DIRECTOR_KEY);
    }

    private String[] getActors(final String showDescription) throws IllegalArgumentException {
        final String stringActors = this.getShowParameterByKey(showDescription, CreateTheaterShowHandler.SHOW_ACTORS_KEY);
        if (stringActors == null) {
            throw new IllegalArgumentException("Actors are not specified");
        }
        return stringActors.split(CreateTheaterShowHandler.SHOW_ACTORS_SEPARATOR);
    }
}
