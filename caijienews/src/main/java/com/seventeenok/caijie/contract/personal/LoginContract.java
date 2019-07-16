package com.seventeenok.caijie.contract.personal;

import com.seventeenok.caijie.model.bean.LoginBean;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.IBaseModel;
import com.zyw.horrarndoo.sdk.base.IBaseView;

import io.reactivex.Observable;

public interface LoginContract {
    abstract class ILoginPresenter extends BasePresenter<ILoginModel, ILoginView> {
        public abstract void clickLogin(String login);

        public abstract void forgetClick();

        public abstract void registClick();
    }

    interface ILoginModel extends IBaseModel {
        Observable<LoginBean> Login(String login);
    }

    interface ILoginView extends IBaseView {
        void loginSuccss();

        void showLoginFailToast();
    }


}
