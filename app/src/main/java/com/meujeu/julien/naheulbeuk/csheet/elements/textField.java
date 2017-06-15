package com.meujeu.julien.naheulbeuk.csheet.elements;

/**
 * Created by Julien on 11/06/2017.
 */

public class textField extends Element {
    public textField() {
        super();
        this.setTextOnly(true);
    }

    public textField(String value) {
        this.setName(value);
    }
}
