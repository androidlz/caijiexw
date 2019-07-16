package com.seventeenok.caijie.contract.home;

import com.seventeenok.caijie.model.bean.hometab.HomeTabBean;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.IBaseFragment;
import com.zyw.horrarndoo.sdk.base.IBaseModel;

import io.reactivex.Observable;

/**
 * Created by root on 2018/5/22.
 */

public interface HomeMainContract {
    //主页接口
    abstract class HomeMainPresenter extends BasePresenter<IHomeMainModel, IHomeMainView> {
        public abstract void getTabList();
    }
    
    interface IHomeMainModel extends IBaseModel {
        Observable<HomeTabBean> getTabs();
    }
    
    interface IHomeMainView extends IBaseFragment {
        void showTabData(HomeTabBean loginBean);
    
        void showNetworkError();
    }
}
