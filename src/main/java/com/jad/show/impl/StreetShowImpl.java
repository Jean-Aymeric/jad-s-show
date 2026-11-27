package com.jad.show.impl;

import com.jad.show.ShowType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreetShowImpl extends ShowImpl {
    private final ArrayList<String> performers = new ArrayList<>();

    public StreetShowImpl(final String name, final String description, final String... performers) {
        super(name, description, ShowType.STREET_SHOW);
        this.performers.addAll(Arrays.asList(performers));
    }

    public List<String> getPerformers() {
        return Collections.unmodifiableList(this.performers);
    }
}
