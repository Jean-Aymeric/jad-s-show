package com.jad;

import com.jad.customer.interfaces.ISpectator;
import com.jad.customer.impl.SpectatorImpl;
import com.jad.show.interfaces.IShow;
import com.jad.show.MovieType;
import com.jad.show.impl.ConcertShowImpl;
import com.jad.show.impl.MovieShowImpl;
import com.jad.show.impl.StreetShowImpl;
import com.jad.show.impl.TheaterShowImpl;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UtilityClassCanBeEnum")
public final class Main {
    public static void main(final String[] args) {
        final ISpectator jad = new SpectatorImpl("Jean-Aymeric", "Diet");

        final List<IShow> shows = new ArrayList<>();
        shows.add(new MovieShowImpl("Titre du film",
                "Description du film",
                "Nom du réalisateur",
                "2023",
                MovieType.SCIENCE_FICTION));
        shows.add(new TheaterShowImpl("Titre du spectacle de théâtre",
                "Description du spectacle de théâtre",
                "Nom du metteur en scène",
                "Nom de l'acteur 1",
                "Nom de l'acteur 2",
                "Nom de l'acteur 3"));
        shows.add(new StreetShowImpl("Titre du spectacle de rue",
                "Description du spectacle de rue",
                "Nom de l'artiste 1",
                "Nom de l'artiste 2",
                "Nom de l'artiste 3"));
        shows.add(new ConcertShowImpl("Titre du concert",
                "Description du concert",
                "Nom de l'artiste ou du groupe"));

        for (final IShow show : shows) {
            jad.watch(show);
        }
    }
}