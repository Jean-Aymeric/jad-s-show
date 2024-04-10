package com.jad.show;

public class CreateShowHandlerChain extends CreateShowHandler {

    private static final CreateShowHandlerChain instance = new CreateShowHandlerChain();

    protected CreateShowHandlerChain() {}

    public static synchronized CreateShowHandlerChain getInstance() {
        if (!instance.hasNextHandler()) {
            instance.addHandler(new CreateConcertShowHandler());
            instance.addHandler(new CreateMovieShowHandler());
            instance.addHandler(new CreateStreetShowHandler());
            instance.addHandler(new CreateTheaterShowHandler());
        }
        return instance;
    }

    @Override
    public IShow handle(String showDescription) {
        if (instance.hasNextHandler()) {
            return instance.getNextHandler().handle(showDescription);
        }
        return null;
    }
}
