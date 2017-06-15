package com.meujeu.julien.naheulbeuk.csheet.elements;

/**
 * Created by Julien on 10/06/2017.
 */

public class Counter extends Element {
    private int value;
    private String name;

    public Counter() {
        super();
    }

    public Counter(String name, int defaultValue) {
        super(name, defaultValue);
    }


}
