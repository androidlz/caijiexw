package com.seventeenok.caijie.adapter.holder;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by root on 2018/5/22.
 */

public class MultipleViewHolder extends BaseViewHolder {
    
    protected MultipleViewHolder(View view) {
        super(view);
    }
    
    public static MultipleViewHolder create(View view) {
        return new MultipleViewHolder(view);
    }
}

