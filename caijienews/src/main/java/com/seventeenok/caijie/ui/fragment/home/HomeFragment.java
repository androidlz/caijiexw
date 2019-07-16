package com.seventeenok.caijie.ui.fragment.home;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.seventeenok.caijie.R;
import com.seventeenok.caijie.contract.home.HomeMainContract;
import com.seventeenok.caijie.model.bean.hometab.HomeTabBean;
import com.seventeenok.caijie.presenter.home.HomeMainPresenter;
import com.seventeenok.caijie.ui.fragment.home.tab.TabFragment;
import com.zyw.horrarndoo.sdk.adapter.FragmentAdapter;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.fragment.BaseMVPCompatFragment;
import com.zyw.horrarndoo.sdk.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.weyye.library.colortrackview.ColorTrackTabLayout;

/**
 * Created by root on 2018/5/18.
 */

public class HomeFragment extends BaseMVPCompatFragment<HomeMainContract.HomeMainPresenter>
        implements HomeMainContract.IHomeMainView {
    
    @BindView(R.id.tab)
    ColorTrackTabLayout mTab;
    @BindView(R.id.vp_home)
    ViewPager mVpHome;
    private List<Fragment> mFragments;
    
    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragments = new ArrayList<>();
    }
    
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.getTabList();
    }
    
    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomeMainPresenter.newInstance();
    }
    
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
    
    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        
    }
    
    @Override
    public void showTabData(HomeTabBean loginBean) {
        List<HomeTabBean.BodyEntity.NavEntity> nav = loginBean.getBody().getNav();
        for (int i = 0; i < nav.size(); i++) {
            HomeTabBean.BodyEntity.NavEntity navEntity = nav.get(i);
            mFragments.add(TabFragment.newInstance(navEntity.getCate_id()
                    , navEntity.getCate_name()));
        }
        mVpHome.setAdapter(new FragmentAdapter(getChildFragmentManager(), mFragments));
        mVpHome.setOffscreenPageLimit(nav.size());
        
        mTab.setTabPaddingLeftAndRight(ScreenUtils.dp2px(mContext, 10)
                , ScreenUtils.dp2px(mContext, 10));
        mTab.setupWithViewPager(mVpHome);
    }
    
    @Override
    public void showNetworkError() {
        
    }
}
