package com.jad.show;

import com.jad.customer.ISpectator;

public abstract class Show implements IShow {

    private final String name;
    private final String description;
    private final ShowType showType;

    protected Show(final String name, final String description, final ShowType showType) {
        this.name = name;
        this.description = description;
        this.showType = showType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public ShowType getShowType() {
        return this.showType;
    }

    @Override
    public void accept(ISpectator spectator) {
        spectator.watch(this);
    }
}
