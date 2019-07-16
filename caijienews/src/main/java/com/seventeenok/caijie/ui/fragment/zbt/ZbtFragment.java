package com.seventeenok.caijie.ui.fragment.zbt;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.seventeenok.caijie.R;
import com.zyw.horrarndoo.sdk.base.fragment.BaseCompatFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZbtFragment extends BaseCompatFragment {

    public static ZbtFragment newInstance() {
        Bundle args = new Bundle();
        ZbtFragment fragment = new ZbtFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ZbtFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_zbt;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

}
