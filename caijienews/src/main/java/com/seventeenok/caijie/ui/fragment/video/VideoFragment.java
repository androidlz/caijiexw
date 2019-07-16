package com.seventeenok.caijie.ui.fragment.video;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.seventeenok.caijie.R;
import com.seventeenok.caijie.ui.fragment.home.HomeRootFragment;
import com.zyw.horrarndoo.sdk.base.fragment.BaseCompatFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseCompatFragment {

    public static VideoFragment newInstance() {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

}
