package com.seventeenok.caijie.ui.fragment.home.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.seventeenok.caijie.R;
import com.seventeenok.caijie.adapter.TabFragmentAdapter;
import com.seventeenok.caijie.contract.home.tab.TabFragmentContract;
import com.seventeenok.caijie.model.multiplemodel.MultipleItemModel;
import com.seventeenok.caijie.presenter.home.tab.TabFragmentPresenter;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.fragment.BaseRecycleFragment;
import com.zyw.horrarndoo.sdk.utils.ToastUtils;
import com.zyw.horrarndoo.sdk.widgets.recydivider.RecyViewBaseDecoration;

import java.util.ArrayList;

import butterknife.BindView;

import static com.seventeenok.caijie.constant.BundleKeyConstant.ARG_KEY_TAB_HOME_FRAGMENT_CATE_ID;
import static com.seventeenok.caijie.constant.BundleKeyConstant.ARG_KEY_TAB_HOME_FRAGMENT_CATE_NAME;

/**
 * Created by root on 2018/5/22.
 */

public class TabFragment extends BaseRecycleFragment<TabFragmentContract.ITabFragmentPresenter>
        implements TabFragmentContract.ITabFragmentView, BaseQuickAdapter.RequestLoadMoreListener {
    
    @BindView(R.id.rv_tab_frag)
    RecyclerView mRVTabFrag; 
    ///
    private TabFragmentAdapter mTabFragmentAdapter;
    private ArrayList<MultipleItemModel> mMultipleItemModels;
    public static TabFragment newInstance(String tabId, String tabName) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY_TAB_HOME_FRAGMENT_CATE_ID, tabId);
        args.putString(ARG_KEY_TAB_HOME_FRAGMENT_CATE_NAME, tabName);
        TabFragment fragment = new TabFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList(getArguments().getString(ARG_KEY_TAB_HOME_FRAGMENT_CATE_ID));
    }
    
    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return new TabFragmentPresenter();
    }
    
    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList(getArguments().getString(ARG_KEY_TAB_HOME_FRAGMENT_CATE_ID));
    }
    
    @Override
    protected void showLoading() {
        mTabFragmentAdapter.setEmptyView(loadingView);
    }
    
    @Override
    public int getLayoutId() {
        return R.layout.tab_fragment;
    }
    
    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        mTabFragmentAdapter = new TabFragmentAdapter(mMultipleItemModels);
        mRVTabFrag.setAdapter(mTabFragmentAdapter);
        mRVTabFrag.addItemDecoration(RecyViewBaseDecoration.create(Color.argb(255, 164, 164, 164), 1));
        mRVTabFrag.setLayoutManager(new LinearLayoutManager(mActivity));
    }
    
    
    @Override
    public void updateContentList(ArrayList<MultipleItemModel> multipleItemModels) {
        //获得数据
        if (mTabFragmentAdapter.getData().size() == 0) {
            initRecycleView(multipleItemModels);
        } else {
//            mTabFragmentAdapter.addData(list);
        }
    }
    private void initRecycleView(ArrayList<MultipleItemModel> multipleItemModels) {
        mTabFragmentAdapter = new TabFragmentAdapter(multipleItemModels);
        mTabFragmentAdapter.setOnLoadMoreListener(this, mRVTabFrag);
        mTabFragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.onItemClick(position, (MultipleItemModel) adapter.getItem(position));
            }
        });
        mRVTabFrag.setAdapter(mTabFragmentAdapter);
    }
    @Override
    public void itemNotifyChanged(int position) {
        
    }
    
    @Override
    public void showNetworkError() {
        mTabFragmentAdapter.setEmptyView(errorView);
    }
    
    @Override
    public void showLoadMoreError() {
        
    }
    
    @Override
    public void showNoMoreData() {
        mTabFragmentAdapter.loadMoreEnd(false);
    }
    
    @Override
    public void onLoadMoreRequested() {
        mTabFragmentAdapter.loadMoreEnd();
        ToastUtils.showToast(getString(R.string.nomoredata));
//        mPresenter.loadMoreList();
    }
}
