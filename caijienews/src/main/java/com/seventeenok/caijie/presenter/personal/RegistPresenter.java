package com.seventeenok.caijie.presenter.personal;

import com.seventeenok.caijie.contract.personal.RegistContract;

public class RegistPresenter extends RegistContract.Presenter {
    public static RegistPresenter newInstance() {
        RegistPresenter presenter = new RegistPresenter();
        return presenter;
    }



    @Override
    public RegistContract.Model getModel() {
        return null;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void getUserRejistData() {

    }
}
