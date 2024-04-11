package com.jad.show;

import static com.jad.show.Helper.getDirector;
import static com.jad.show.Helper.getFieldValueByName;
import static com.jad.show.Helper.isShowType;

public class CreateTheaterShowHandler extends CreateShowHandler {

    protected CreateTheaterShowHandler() {}

    @Override
    public IShow handle(String showDescription) throws IllegalArgumentException {
        if (isShowType(ShowType.THEATER, showDescription)) {
            return new TheaterShow(getName(showDescription),
                                   getDescription(showDescription),
                                   getDirector(showDescription),
                                   getActors(showDescription));
        }
        if(getNextHandler() == null) {throw new IllegalArgumentException("Unsupported Expression");}
        return getNextHandler().handle(showDescription);

    }

    public static String[] getActors(String showDescription) {
        return getFieldValueByName(showDescription, "actors").split(",");
    }

}
