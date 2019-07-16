package com.zyw.horrarndoo.sdk.widgets.recydivider;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by root on 2018/5/23.
 */

public class RecyViewBaseDecoration extends DividerItemDecoration {
    
    private RecyViewBaseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(color, size));
    }
    
    public static RecyViewBaseDecoration create(@ColorInt int color, int size) {
        return new RecyViewBaseDecoration(color, size);
    }
}
