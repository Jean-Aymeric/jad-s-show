package com.jad.show;

class CreateConcertShowHandler extends CreateShowHandler {
    public CreateConcertShowHandler() {
        super(ShowType.CONCERT);
    }

    @Override
    public IShow handle(final String showDescription) {
        if (this.getShowTypeHandled() == this.getShowType(showDescription)) {
            return this.createConcertShow(showDescription);
        } else {
            return this.getNextHandler().handle(showDescription);
        }
    }

    private IShow createConcertShow(final String showDescription) throws IllegalArgumentException {
        return ShowFactory.makeConcertShow(
                this.getShowName(showDescription),
                this.getShowDescription(showDescription),
                this.getArtist(showDescription));
    }

    private String getArtist(final String showDescription) throws IllegalArgumentException {
        return this.getShowParameterByKey(showDescription, "artist");
    }
}
