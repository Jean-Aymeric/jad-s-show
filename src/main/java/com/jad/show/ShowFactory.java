package com.jad.show;

public abstract class ShowFactory {

    public static IShow makeShow(final String showDescription) {
        return CreateShowHandlerChain.getInstance().handle(showDescription);
    }
}
