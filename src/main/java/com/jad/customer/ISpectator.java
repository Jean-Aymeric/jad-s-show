package com.jad.customer;

import com.jad.show.*;

public interface ISpectator {
    String getFirstName();

    String getLastName();

    void watch(final IShow show);

    void watch(final ConcertShow show);

    void watch(final MovieShow show);

    void watch(final StreetShow show);

    void watch(final TheaterShow show);
}
