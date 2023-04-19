package com.jad.customer;

import com.jad.show.*;

import java.text.MessageFormat;
import java.util.stream.Collectors;

public class Spectator implements ISpectator {
    private final String firstName;
    private final String lastName;

    public Spectator(final String firstName, final String lastName) {
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
        show.askToWatch(this);
    }

    @Override
    public void watch(final ConcertShow show) {
        System.out.println(MessageFormat.format("""
                        J''ai assisté au concert {0} de {1}
                        """,
                show.getName(),
                show.getArtist()));
    }

    @Override
    public void watch(final MovieShow show) {
        System.out.println(MessageFormat.format("""
                        J''ai assisté au film {0} de {1} sorti en {2}
                        """,
                show.getName(),
                show.getDirector(),
                show.getYearOfRelease()));
    }

    @Override
    public void watch(final StreetShow show) {
        System.out.println(MessageFormat.format("""
                        J''ai assisté au spectacle de rue {0}.
                        Il y avait : {1}
                        """,
                show.getName(),
                show.getPerformers().stream().map(performer -> MessageFormat.format("{0}", performer) + ", ").collect(Collectors.joining())));
    }

    @Override
    public void watch(final TheaterShow show) {
        System.out.println(MessageFormat.format("""
                        J''ai assisté à la pièce de théâtre {0} de {1}.
                        Il y avait : {2}
                        """,
                show.getName(),
                show.getDirector(),
                show.getActors().stream().map(actor -> MessageFormat.format("{0}", actor) + ", ").collect(Collectors.joining())));
    }
}
