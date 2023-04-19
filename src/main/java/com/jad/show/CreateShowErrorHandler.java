package com.jad.show;

class CreateShowErrorHandler extends CreateShowHandler {
    public CreateShowErrorHandler() {
        super(null);
    }

    @Override
    public IShow handle(final String showDescription) throws IllegalArgumentException {
        throw new IllegalArgumentException("Description is not valid");
    }
}
