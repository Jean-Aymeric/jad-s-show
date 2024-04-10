package com.jad.show;

import static com.jad.show.Helper.getFieldValueByName;
import static com.jad.show.Helper.isShowType;

public class CreateStreetShowHandler extends CreateShowHandler {

    protected CreateStreetShowHandler() {}

    @Override
    public IShow handle(String showDescription) {
        if (isShowType(ShowType.STREET_SHOW, showDescription)) {
            return new StreetShow(getName(showDescription),
                                  getDescription(showDescription),
                                  getPerformers(showDescription));
        }
        return getNextHandler().handle(showDescription);
    }

    public static String[] getPerformers(String showDescription) {
        return getFieldValueByName(showDescription, "performers").split(",");
    }
}
