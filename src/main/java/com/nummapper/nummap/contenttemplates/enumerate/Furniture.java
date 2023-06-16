package com.nummapper.nummap.contenttemplates.enumerate;

import com.nummapper.nummap.contenttemplates.exceptions.DataNotFoundException;

public enum Furniture {
    CHAIR(1, "Chair"),
    TABLE(2, "Table"),
    SOFA(3, "Sofa"),
    BED(4, "Bed"),
    DESK(5, "Desk"),
    SHELF(6, "Shelf"),
    DRESSER(7, "Dresser"),
    COUCH(8, "Couch"),
    OTTOMAN(9, "Ottoman"),
    CABINET(10, "Cabinet"),
    BOOKCASE(11, "Bookcase"),
    BENCH(12, "Bench"),
    WARDROBE(13, "Wardrobe"),
    TV_STAND(14, "TV Stand"),
    COFFEE_TABLE(15, "Coffee Table"),
    NIGHTSTAND(16, "Nightstand"),
    SIDEBOARD(17, "Sideboard"),
    ARMCHAIR(18, "Armchair"),
    HUTCH(19, "Hutch"),
    STOOL(20, "Stool");

    private int position;
    private String name;

    Furniture(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public static String getNameByPosition(int position) {
        for (Furniture furniture : Furniture.values()) {
            if (furniture.getPosition() == position) {
                return furniture.getName();
            }
        }
        throw new DataNotFoundException("Value of the :" + position + " is incorrect - unknown" );
    }
}
