package com.meujeu.julien.naheulbeuk.csheet.elements;

/**
 * Created by Julien on 11/06/2017.
 */

public class Element {
    private String name;
    private int value;
    private boolean textOnly;
    private int defaultValue;


    public Element() {
        this("nom", 0);
    }

    public Element(String defaultName, int defaultValue) {
        this.name = defaultName;
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.textOnly = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void add(int value) {
        this.value += value;
    }

    public void plusOne() {
        value++;
    }

    public void minusOne() {
        value--;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isTextOnly() {
        return textOnly;
    }

    public void setTextOnly(boolean textOnly) {
        this.textOnly = textOnly;
    }

}
