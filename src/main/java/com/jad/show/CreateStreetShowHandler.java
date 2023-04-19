package com.jad.show;

class CreateStreetShowHandler extends CreateShowHandler {
    public static final String SHOW_PERFORMERS_SEPARATOR = ",";
    private static final String SHOW_PERFORMERS_KEY = "performers";

    public CreateStreetShowHandler() {
        super(ShowType.STREET_SHOW);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (this.getShowTypeHandled() == this.getShowType(showDescription)) {
            return this.createStreetShow(showDescription);
        } else {
            return this.getNextHandler().handle(showDescription);
        }
    }

    private IShow createStreetShow(final String showDescription) throws IllegalArgumentException {
        return ShowFactory.makeStreetShow(
                this.getShowName(showDescription),
                this.getShowDescription(showDescription),
                this.getActors(showDescription));
    }

    private String[] getActors(final String showDescription) throws IllegalArgumentException {
        final String stringActors = this.getShowParameterByKey(showDescription, CreateStreetShowHandler.SHOW_PERFORMERS_KEY);
        if (stringActors == null) {
            throw new IllegalArgumentException("Performers are not specified");
        }
        return stringActors.split(CreateStreetShowHandler.SHOW_PERFORMERS_SEPARATOR);
    }
}
