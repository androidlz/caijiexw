package com.seventeenok.caijie.presenter.home;

import android.support.annotation.NonNull;

import com.seventeenok.caijie.contract.home.HomeMainContract;
import com.seventeenok.caijie.model.bean.hometab.HomeTabBean;
import com.seventeenok.caijie.model.home.HomeMainModel;
import com.zyw.horrarndoo.sdk.utils.LogUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by root on 2018/5/22.
 */

public class HomeMainPresenter extends HomeMainContract.HomeMainPresenter {
    
    @NonNull
    public static HomeMainPresenter newInstance() {
        return new HomeMainPresenter();
    }
    
    
    @Override
    public HomeMainContract.IHomeMainModel getModel() {
        return HomeMainModel.newInstance();
    }
    
    @Override
    public void onStart() {
        
    }
    
    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;
    
        mRxManager.register(mIModel.getTabs().subscribe(new Consumer<HomeTabBean>() {
            @Override
            public void accept(HomeTabBean loginBean) throws Exception {
                if (mIView == null)
                    return;
                mIView.showTabData(loginBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView == null)
                    return;
                LogUtils.e(throwable);
                mIView.showToast("网络错误");
                mIView.showNetworkError();
            }
        }));
    }
}