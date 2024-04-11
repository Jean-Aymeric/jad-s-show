package com.jad.show;

import com.jad.customer.ISpectator;

public interface IShow {

    String getName();

    String getDescription();

    ShowType getShowType();

    void present();

    void accept(ISpectator spectator);
}
