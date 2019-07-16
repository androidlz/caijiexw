package com.seventeenok.caijie.ui.fragment.personal.child;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.seventeenok.caijie.R;
import com.zyw.horrarndoo.sdk.base.fragment.BaseCompatFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class WGLandFragment extends BaseCompatFragment {
    public static WGLandFragment newInstance() {
        Bundle args = new Bundle();
        WGLandFragment fragment = new WGLandFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wgland;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

}
