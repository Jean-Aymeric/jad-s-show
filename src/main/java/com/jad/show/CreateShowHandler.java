package com.jad.show;

abstract class CreateShowHandler {
    private static final String TYPE_SHOW_SEPARATOR = ":";
    private static final String SHOW_NAME_KEY = "name";
    private static final String SHOW_DESCRIPTION_KEY = "description";
    private static final String PARAMETER_SEPARATOR = ";";
    private static final String PARAMETER_VALUE_SEPARATOR = "=";
    private final ShowType showTypeHandled;
    private CreateShowHandler nextHandler;

    public CreateShowHandler(final ShowType showTypeHandled) {
        this.showTypeHandled = showTypeHandled;
        this.nextHandler = null;
    }

    public ShowType getShowTypeHandled() {
        return this.showTypeHandled;
    }

    public abstract IShow handle(final String showDescription) throws IllegalArgumentException;

    public CreateShowHandler getNextHandler() {
        return this.nextHandler;
    }

    public boolean hasNextHandler() {
        return this.nextHandler != null;
    }

    public void addHandler(final CreateShowHandler nextHandler) {
        if (this.hasNextHandler()) {
            this.nextHandler.addHandler(nextHandler);
        } else {
            this.nextHandler = nextHandler;
        }
    }

    protected ShowType getShowType(final String showDescription) {
        final ShowType showType;
        if (showDescription != null) {
            showType = ShowType.valueOf(showDescription.split(CreateShowHandler.TYPE_SHOW_SEPARATOR)[0]);
        } else {
            throw new IllegalArgumentException("The show description is not valid");
        }
        return showType;
    }

    protected String getShowName(final String showDescription) throws IllegalArgumentException {
        return this.getShowParameterByKey(showDescription, CreateShowHandler.SHOW_NAME_KEY);
    }

    protected String getShowParameterByKey(final String showDescription, final String key) throws IllegalArgumentException {
        final String parameters = showDescription.split(CreateShowHandler.TYPE_SHOW_SEPARATOR)[1];
        final String[] parametersArray = parameters.split(CreateShowHandler.PARAMETER_SEPARATOR);
        for (final String parameter : parametersArray) {
            if (parameter.startsWith(key)) {
                return parameter.split(CreateShowHandler.PARAMETER_VALUE_SEPARATOR)[1];
            }
        }
        throw new IllegalArgumentException("The show " + key + " is not valid");
    }

    protected String getShowDescription(final String showDescription) throws IllegalArgumentException {
        return this.getShowParameterByKey(showDescription, CreateShowHandler.SHOW_DESCRIPTION_KEY);
    }
}
