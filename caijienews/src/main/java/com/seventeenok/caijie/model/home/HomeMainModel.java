package com.seventeenok.caijie.model.home;

import android.support.annotation.NonNull;

import com.seventeenok.caijie.api.JRCJApi;
import com.seventeenok.caijie.contract.home.HomeMainContract;
import com.seventeenok.caijie.model.bean.hometab.HomeTabBean;
import com.seventeenok.caijie.util.RetrofitCreateHelper;
import com.zyw.horrarndoo.sdk.base.BaseModel;
import com.zyw.horrarndoo.sdk.helper.RxHelper;

import org.json.JSONObject;

import io.reactivex.Observable;

import static com.seventeenok.caijie.util.RetrofitCreateHelper.createRequestBody;

/**
 * Created by root on 2018/5/22.
 */

public class HomeMainModel extends BaseModel implements HomeMainContract.IHomeMainModel {
    
    @NonNull
    public static HomeMainModel newInstance() {
        return new HomeMainModel();
    }
    
    @Override
    public Observable<HomeTabBean> getTabs() {
        return RetrofitCreateHelper.createApi(JRCJApi.class, JRCJApi.HOST)
                .getHomeTab(createRequestBody(new JSONObject()))
                .compose(RxHelper.<HomeTabBean>rxSchedulerHelper());
    }
}
