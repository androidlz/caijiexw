package com.seventeenok.caijie.contract.personal;

import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.IBaseModel;
import com.zyw.horrarndoo.sdk.base.IBaseView;

public interface RegistContract {
    interface Model extends IBaseModel {

    }

    interface View extends IBaseView{
    }

    abstract  class Presenter extends BasePresenter<Model,View>{
        public abstract void   getUserRejistData();
    }
}
