package com.jad;

import com.jad.customer.*;
import com.jad.show.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UtilityClassCanBeEnum")
public final class Main {
    public static void main(final String[] args) {
        final ISpectator jad = new Spectator("Jean-Aymeric", "Diet");

        final List<IShow> shows = new ArrayList<>();
        shows.add(new MovieShow("Dune 2",
                "Description du film",
                "Ridley Scott",
                "2023",
                MovieType.SCIENCE_FICTION));
        shows.add(new TheaterShow("QQQQ",
                "Description du spectacle de théâtre",
                "Nom du metteur en scène",
                "Nom de l'acteur 1",
                "Nom de l'acteur 2",
                "Nom de l'acteur 3"));
        shows.add(new StreetShow("Titre du spectacle de rue",
                "Description du spectacle de rue",
                "Nom de l'artiste 1",
                "Nom de l'artiste 2",
                "Nom de l'artiste 3"));
        shows.add(new ConcertShow("Titre du concert",
                "Description du concert",
                "Nom de l'artiste ou du groupe"));

        for (final IShow show : shows) {
            jad.watch(show);
        }
    }
}
