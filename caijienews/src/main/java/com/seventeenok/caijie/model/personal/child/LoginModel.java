package com.seventeenok.caijie.model.personal.child;

import android.support.annotation.NonNull;

import com.seventeenok.caijie.api.JRCJApi;
import com.seventeenok.caijie.contract.personal.LoginContract;
import com.seventeenok.caijie.model.bean.LoginBean;
import com.seventeenok.caijie.util.RetrofitCreateHelper;
import com.zyw.horrarndoo.sdk.helper.RxHelper;

import org.json.JSONObject;

import io.reactivex.Observable;

import static com.seventeenok.caijie.util.RetrofitCreateHelper.createRequestBody;

public class LoginModel implements LoginContract.ILoginModel {
    @NonNull
    public static LoginModel newInstance() {
        return new LoginModel();
    }

    @Override
    public Observable<LoginBean> Login(String  login) {
//        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),login);
        return RetrofitCreateHelper.createApi(JRCJApi.class, JRCJApi.HOST)
                .getLoginInfo(createRequestBody(new JSONObject()))
                .compose(RxHelper.<LoginBean>rxSchedulerHelper());
    }
}
