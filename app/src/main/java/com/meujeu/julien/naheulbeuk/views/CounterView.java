package com.meujeu.julien.naheulbeuk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Julien on 11/06/2017.
 */

public class CounterView extends View {
    public CounterView(Context context) {
        super(context);
    }

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CounterView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    public void setValue(int value) {
        CounterUtils.setValue(this, value);
    }
}
