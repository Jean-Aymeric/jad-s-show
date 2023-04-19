package com.jad.show;

class CreateShowHandlerChain extends CreateShowHandler {
    private static final CreateShowHandlerChain INSTANCE = new CreateShowHandlerChain();

    private CreateShowHandlerChain() {
        super(null);
    }

    public static synchronized CreateShowHandlerChain getInstance() {
        if (!CreateShowHandlerChain.INSTANCE.hasNextHandler()) {
            CreateShowHandlerChain.INSTANCE.addHandler(new CreateConcertShowHandler());
            CreateShowHandlerChain.INSTANCE.addHandler(new CreateMovieShowHandler());
            CreateShowHandlerChain.INSTANCE.addHandler(new CreateTheaterShowHandler());
            CreateShowHandlerChain.INSTANCE.addHandler(new CreateStreetShowHandler());
            CreateShowHandlerChain.INSTANCE.addHandler(new CreateShowErrorHandler());
        }
        return CreateShowHandlerChain.INSTANCE;
    }

    @Override
    public IShow handle(final String showDescription) {
        if (this.hasNextHandler()) {
            return this.getNextHandler().handle(showDescription);
        }
        return null;
    }
}
