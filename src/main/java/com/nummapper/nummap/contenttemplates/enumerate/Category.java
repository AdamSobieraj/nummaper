package com.nummapper.nummap.contenttemplates.enumerate;

public enum Category {

    ANIMALS(1, "Animals"),
    FURNITURE(2, "Furniture");

    private final int position;
    private final String name;

    private Category(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
