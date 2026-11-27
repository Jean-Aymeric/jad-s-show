package com.jad.customer.impl;

import com.jad.customer.interfaces.ISpectator;
import com.jad.show.interfaces.IShow;

public class SpectatorImpl implements ISpectator {
    private final String firstName;
    private final String lastName;

    public SpectatorImpl(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void watch(final IShow show) {
        // TODO: Implement this method
    }
}
