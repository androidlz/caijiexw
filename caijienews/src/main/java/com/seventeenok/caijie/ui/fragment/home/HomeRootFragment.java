package com.seventeenok.caijie.ui.fragment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.seventeenok.caijie.R;
import com.zyw.horrarndoo.sdk.base.fragment.BaseCompatFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeRootFragment extends BaseCompatFragment {

    public static HomeRootFragment newInstance() {
        Bundle args = new Bundle();
        HomeRootFragment fragment = new HomeRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public HomeRootFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_root;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(HomeFragment.class) == null) {
            loadRootFragment(R.id.fl_container, HomeFragment.newInstance());
        }
    }

}
