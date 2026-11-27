package com.jad.customer.interfaces;

import com.jad.show.interfaces.IShow;

public interface ISpectator {
    String getFirstName();

    String getLastName();

    void watch(IShow show);
}
