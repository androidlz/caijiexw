package com.seventeenok.caijie.contract.home.tab;

import com.seventeenok.caijie.model.bean.hometab.TabFragmentBean;
import com.seventeenok.caijie.model.multiplemodel.MultipleItemModel;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by root on 2018/5/22.
 */

public interface TabFragmentContract {
    abstract class ITabFragmentPresenter extends BaseTabsContract.BaseTabsPresenter<ITabFragmentModel,
            ITabFragmentView, MultipleItemModel> {
    }
    
    interface ITabFragmentModel extends BaseTabsContract.IBaseTabsModel {
        Observable<ArrayList<MultipleItemModel>> getNewsData(String cateId);
    }
    
    interface ITabFragmentView extends BaseTabsContract.IBaseTabsView<TabFragmentBean> {
        
    }
    
    
}
