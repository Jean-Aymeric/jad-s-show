package com.jad.show;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class StreetShow extends Show {
    private final ArrayList<String> performers = new ArrayList<>();

    protected StreetShow(final String name, final String description, final String... performers) {
        super(name, description, ShowType.STREET_SHOW);
        this.performers.addAll(Arrays.asList(performers));
    }

    public List<String> getPerformers() {
        return Collections.unmodifiableList(this.performers);
    }

    @Override
    public void present() {
        log.info("J'ai assisté au spectacle de rue "+this.getName()+" Il y avait : "+String.join(", ",getPerformers()));
    }
}
