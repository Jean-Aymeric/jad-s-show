package com.jad;

import com.jad.customer.ISpectator;
import com.jad.customer.Spectator;
import com.jad.show.IShow;
import com.jad.show.ShowFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UtilityClassCanBeEnum")
public final class Main {

    public static void main(final String[] args) {
        final ISpectator jad = new Spectator("Jean-Aymeric", "Diet");

        final List<IShow> shows = new ArrayList<>();

        shows.add(ShowFactory.makeShow(
                "MOVIE:name=Titre du film;" +
                "description=Description du film;" + "director=Nom du réalisateur;" +
                "yearOfRelease=2023;" +
                "movieType=SCIENCE_FICTION"));
        for (final IShow show : shows) {
            jad.watch(show);
        }

    }
}
