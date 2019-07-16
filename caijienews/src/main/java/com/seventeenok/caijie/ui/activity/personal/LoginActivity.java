package com.seventeenok.caijie.ui.activity.personal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.seventeenok.caijie.R;
import com.seventeenok.caijie.contract.personal.LoginContract;
import com.seventeenok.caijie.presenter.personal.child.LoginPresenter;
import com.seventeenok.caijie.util.Imei;
import com.seventeenok.caijie.util.InputForm;
import com.seventeenok.caijie.util.MD5;
import com.seventeenok.caijie.util.RestRequest;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.activity.BaseMVPCompatActivity;
import com.zyw.horrarndoo.sdk.utils.LogUtils;
import com.zyw.horrarndoo.sdk.widgets.BaseTitleBar;

import java.util.WeakHashMap;

import butterknife.BindView;
import butterknife.OnClick;

import static com.seventeenok.caijie.util.RandomText.initRandomText;

public class LoginActivity extends BaseMVPCompatActivity<LoginPresenter> implements LoginContract.ILoginView {
    BaseTitleBar lzBar;
    @BindView(R.id.edt_login_phonenumber)
    TextInputEditText edtLoginPhonenumber;
    @BindView(R.id.edt_Login_InputPassword)
    TextInputEditText edtLoginInputPassword;
    @BindView(R.id.imgv_login_eye)
    CheckBox imgvLoginEye;
    @BindView(R.id.bt_login)
    AppCompatTextView btLogin;
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.tv_login_register)
    TextView tvLoginRegister;
    @BindView(R.id.imgv_login_weixin)
    ImageView imgvLoginWeixin;
    @BindView(R.id.imgv_login_weibo)
    ImageView imgvLoginWeibo;
    @BindView(R.id.imgv_login_qq)
    ImageView imgvLoginQq;
    private String reqRandomText;

    @Override
    protected void initView(Bundle savedInstanceState) {
        lzBar = findViewById(R.id.lzBar);
        lzBar.setRootColor("#ffffff").setText("登录").setTextColor("#000000");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return LoginPresenter.newInstance();
    }


    @OnClick({R.id.bt_login, R.id.tv_forget_password, R.id.tv_login_register, R.id.imgv_login_weixin, R.id.imgv_login_weibo, R.id.imgv_login_qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                mPresenter.clickLogin(login());
                break;
            case R.id.tv_forget_password:
                break;
            case R.id.tv_login_register:
                break;
            case R.id.imgv_login_weixin:
                break;
            case R.id.imgv_login_weibo:
                break;
            case R.id.imgv_login_qq:
                break;
        }
    }

    private String login() {
        if (InputForm.checkForm(edtLoginPhonenumber, edtLoginInputPassword)) {
            String phoneSign = Imei.getPhoneSign(this);
            reqRandomText = initRandomText(-1);
            WeakHashMap<String, Object> mapParamsHeader = new WeakHashMap<>();
            mapParamsHeader.put("userid", "");
            mapParamsHeader.put("token", "");
            WeakHashMap<String, Object> mapParamsBody = new WeakHashMap<>();
            mapParamsBody.put("type", 0);
            mapParamsBody.put("user_name", edtLoginPhonenumber.getText().toString());
            mapParamsBody.put("password", reqRandomText + MD5.getMD5Str(edtLoginInputPassword.getText().toString()) + initRandomText(reqRandomText.length()));
            mapParamsBody.put("len_info", reqRandomText.length());
            mapParamsBody.put("openstr", "");
            mapParamsBody.put("imei", phoneSign);
            String restRequest = new RestRequest().create(mapParamsHeader, mapParamsBody);
            LogUtils.e(restRequest);
            return restRequest;
        }
        return null;
    }


    @Override
    public void loginSuccss() {
        showToast("登录成功");
        finish();
    }

    @Override
    public void showLoginFailToast() {

    }
}
