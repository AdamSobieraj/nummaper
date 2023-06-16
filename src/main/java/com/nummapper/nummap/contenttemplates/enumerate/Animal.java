package com.nummapper.nummap.contenttemplates.enumerate;

import com.nummapper.nummap.contenttemplates.exceptions.DataNotFoundException;

public enum Animal {
    DOG(1, "Dog"),
    CAT(2, "Cat"),
    ELEPHANT(3, "Elephant"),
    LION(4, "Lion"),
    TIGER(5, "Tiger"),
    BEAR(6, "Bear"),
    PENGUIN(7, "Penguin"),
    SNAKE(8, "Snake"),
    GORILLA(9, "Gorilla"),
    RABBIT(10, "Rabbit"),
    FOX(11, "Fox"),
    OWL(12, "Owl"),
    ZEBRA(13, "Zebra"),
    KANGAROO(14, "Kangaroo"),
    GIRAFFE(15, "Giraffe"),
    HIPPO(16, "Hippo"),
    WOLF(17, "Wolf"),
    LEMUR(18, "Lemur"),
    CHEETAH(19, "Cheetah"),
    PANDA(20, "Panda");

    private final int position;
    private final String name;

    Animal(int position, String name) {
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
        for (Animal animal : Animal.values()) {
            if (animal.getPosition() == position) {
                return animal.getName();
            }
        }
        throw new DataNotFoundException("Value of the :" + position + " is incorrect - unknown" );
    }
}
