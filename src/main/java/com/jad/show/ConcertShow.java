package com.jad.show;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcertShow extends Show {
    private final String artist;

    public ConcertShow(final String name, final String description, final String artist) {
        super(name, description, ShowType.CONCERT);
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }

    @Override
    public void present() {
        log.info("J'ai assisté au concert "+this.getName()+" de "+this.getArtist());
    }
}
