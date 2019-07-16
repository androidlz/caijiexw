package com.seventeenok.caijie.presenter.home.tab;

import android.support.annotation.NonNull;

import com.seventeenok.caijie.contract.home.tab.TabFragmentContract;
import com.seventeenok.caijie.model.home.tab.TabFragmentModel;
import com.seventeenok.caijie.model.multiplemodel.MultipleItemModel;
import com.zyw.horrarndoo.sdk.utils.ToastUtils;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * Created by root on 2018/5/22.
 */

public class TabFragmentPresenter extends TabFragmentContract.ITabFragmentPresenter {
    @NonNull
    public static TabFragmentPresenter newInstance() {
        return new TabFragmentPresenter();
    }
    
    @Override
    public TabFragmentContract.ITabFragmentModel getModel() {
        return TabFragmentModel.newInstance();
    }
    
    @Override
    public void onStart() {
        
    }
    
    @Override
    public void loadLatestList(String cateId) {
        if (mIModel == null)
            return;
    
        mRxManager.register(mIModel.getNewsData(cateId).subscribe(new Consumer<ArrayList<MultipleItemModel>>() {
            @Override
            public void accept(ArrayList<MultipleItemModel> multipleItemModels) throws Exception {
                if (mIView != null)
                    mIView.updateContentList(multipleItemModels);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView != null) {
                    if (mIView.isVisiable())
                    mIView.showNetworkError();
                }
            }
        }));
    }
    
    @Override
    public void loadMoreList() {
        
    }
    
    @Override
    public void onItemClick(int position, MultipleItemModel item) {
        ToastUtils.showToast("点击了-->"+position);
    }
}
