package com.jad.show;

import static com.jad.show.Helper.getFieldValueByName;
import static com.jad.show.Helper.isShowType;

public class CreateConcertShowHandler extends CreateShowHandler {

    protected CreateConcertShowHandler() {}

    @Override
    public IShow handle(String showDescription) {
        if (isShowType(ShowType.CONCERT, showDescription)) {
            return new ConcertShow(getName(showDescription),
                                   getDescription(showDescription),
                                   getArtist(showDescription));
        }
        return getNextHandler().handle(showDescription);
    }

    private String getArtist(String showDescription) {
        return  getFieldValueByName(showDescription, "artist");
    }
}
