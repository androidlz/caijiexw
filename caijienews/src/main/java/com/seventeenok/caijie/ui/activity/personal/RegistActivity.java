package com.seventeenok.caijie.ui.activity.personal;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.seventeenok.caijie.R;
import com.seventeenok.caijie.presenter.personal.RegistPresenter;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.activity.BaseMVPCompatActivity;

public class RegistActivity extends BaseMVPCompatActivity<RegistPresenter> {



    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return RegistPresenter.newInstance();
    }
}
