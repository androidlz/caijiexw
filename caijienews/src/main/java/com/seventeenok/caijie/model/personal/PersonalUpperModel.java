package com.seventeenok.caijie.model.personal;

import android.support.annotation.NonNull;

import com.seventeenok.caijie.contract.personal.PersonalContract;

/**
 * Created by Horrarndoo on 2017/9/26.
 * <p>
 */

public class PersonalUpperModel implements PersonalContract.IPersonalUpperModel {

    @NonNull
    public static PersonalUpperModel newInstance() {
        return new PersonalUpperModel();
    }
}
