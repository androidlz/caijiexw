package com.seventeenok.caijie.ui.fragment.personal;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;

import com.seventeenok.caijie.R;
import com.zyw.horrarndoo.sdk.base.fragment.BaseCompatFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalRootFragment extends BaseCompatFragment {

    @BindView(R.id.fl_personal_container_upper)
    FrameLayout flContainerUpper;
    @BindView(R.id.fl_personal_container_lower)
    FrameLayout flContainerLower;

    public static PersonalRootFragment newInstance() {
        Bundle args = new Bundle();
        PersonalRootFragment fragment = new PersonalRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PersonalRootFragment() {
        // Required empty public constructor
    }




    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState == null) {
            loadFragment();
        } else {  // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
            if (findChildFragment(PersonalUpperFragment.class) == null||findChildFragment(PersonalLowerFragment.class) == null) {
                loadFragment();
            }
        }
    }

    private void loadFragment() {
        loadRootFragment(R.id.fl_personal_container_upper, PersonalUpperFragment.newInstance());
        loadRootFragment(R.id.fl_personal_container_lower, PersonalLowerFragment.newInstance());
    }
}
