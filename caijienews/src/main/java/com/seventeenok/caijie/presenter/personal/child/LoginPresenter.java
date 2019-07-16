package com.seventeenok.caijie.presenter.personal.child;

import android.support.annotation.NonNull;

import com.seventeenok.caijie.contract.personal.LoginContract;
import com.seventeenok.caijie.model.bean.LoginBean;
import com.seventeenok.caijie.model.personal.child.LoginModel;
import com.zyw.horrarndoo.sdk.utils.LogUtils;

import io.reactivex.functions.Consumer;

public class LoginPresenter extends LoginContract.ILoginPresenter{
    @Override
    public LoginContract.ILoginModel getModel() {
        return LoginModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @NonNull
    public static LoginPresenter newInstance() {
        return new LoginPresenter();
    }


    @Override
    public void clickLogin(String login) {
        if (mIView == null || mIModel == null)
            return;

        mRxManager.register(mIModel.Login(login).subscribe(new Consumer<LoginBean>() {
            @Override
            public void accept(LoginBean loginBean) throws Exception {
                mIView.loginSuccss();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView == null)
                    return;
                LogUtils.e(throwable);
                mIView.showToast("网络错误");
            }
        }));
    }



    @Override
    public void forgetClick() {

    }

    @Override
    public void registClick() {

    }
}
