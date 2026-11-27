package com.jad.show.impl;

import com.jad.show.ShowType;

public class ConcertShowImpl extends ShowImpl {
    private final String artist;

    public ConcertShowImpl(final String name, final String description, final String artist) {
        super(name, description, ShowType.CONCERT);
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }
}
