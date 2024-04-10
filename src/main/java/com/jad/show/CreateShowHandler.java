package com.jad.show;

import static com.jad.show.Helper.getFieldValueByName;

public abstract class CreateShowHandler {

    private CreateShowHandler nextHandler;

    protected CreateShowHandler() {}

    public CreateShowHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(CreateShowHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public boolean hasNextHandler() {
        return nextHandler != null;
    }

    public void addHandler(CreateShowHandler nextHandler) {
        if (hasNextHandler()) {
            this.nextHandler.addHandler(nextHandler);
        } else {
            this.nextHandler = nextHandler;
        }
    }

    public abstract IShow handle(String showDescription);

    public String getName(String showDescription) {
        return getFieldValueByName(showDescription, "name");
    }

    public String getDescription(String showDescription) {
        return getFieldValueByName(showDescription, "description");
    }

}
