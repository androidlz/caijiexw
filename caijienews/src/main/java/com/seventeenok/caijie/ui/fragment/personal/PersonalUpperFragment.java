package com.seventeenok.caijie.ui.fragment.personal;


import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seventeenok.caijie.R;
import com.seventeenok.caijie.contract.personal.PersonalContract;
import com.seventeenok.caijie.model.bean.rxbus.RxEventHeadBean;
import com.seventeenok.caijie.presenter.personal.PersonalUpperPresenter;
import com.seventeenok.caijie.ui.activity.personal.HeadSettingActivity;
import com.seventeenok.caijie.ui.activity.personal.LoginActivity;
import com.seventeenok.caijie.ui.activity.personal.RegistActivity;
import com.seventeenok.caijie.ui.widgets.PersonalPopupWindow;
import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.base.fragment.BaseMVPCompatFragment;
import com.zyw.horrarndoo.sdk.rxbus.RxBus;
import com.zyw.horrarndoo.sdk.rxbus.Subscribe;
import com.zyw.horrarndoo.sdk.utils.AppUtils;
import com.zyw.horrarndoo.sdk.utils.FileUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.seventeenok.caijie.constant.RxBusCode.RX_BUS_CODE_HEAD_IMAGE_URI;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalUpperFragment extends BaseMVPCompatFragment<PersonalUpperPresenter> implements PersonalContract.IPersonalUpperView {

    PersonalPopupWindow popupWindow;
    @BindView(R.id.civ_head)
    CircleImageView civHead;
    @BindView(R.id.tv_sign_in)
    TextView tvSignIn;
    @BindView(R.id.tv_reg_in)
    TextView tvRegIn;
    @BindView(R.id.ll_sign_reg)
    LinearLayout llSignReg;
    @BindView(R.id.tv_user_name)
    AppCompatTextView tvUserName;
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    Unbinder unbinder;

    public static PersonalUpperFragment newInstance() {
        Bundle args = new Bundle();
        PersonalUpperFragment fragment = new PersonalUpperFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PersonalUpperFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_upper;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        initPopupView();
    }

    @Override
    public void initPopupView() {
        popupWindow = new PersonalPopupWindow(mActivity);
        popupWindow.setOnItemClickListener(new PersonalPopupWindow.OnItemClickListener() {
            @Override
            public void onCaremaClicked() {
                mPresenter.btnCameraClicked();
            }

            @Override
            public void onPhotoClicked() {
                mPresenter.btnPhotoClicked();
            }

            @Override
            public void onCancelClicked() {
                mPresenter.btnCancelClicked();
            }
        });
    }

    @Override
    public void showHead(Bitmap bitmap) {
        civHead.setImageBitmap(bitmap);
    }

    @Override
    public void showPopupView() {
        View parent = LayoutInflater.from(mActivity).inflate(R.layout.fragment_personal, null);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.LEFT, 0, 0);
    }

    @Override
    public void dismissPopupView() {
        popupWindow.dismiss();
    }

    @Override
    public boolean popupIsShowing() {
        return popupWindow.isShowing();
    }

    @Override
    public void gotoHeadSettingActivity(Uri uri) {
        if (uri == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mActivity, HeadSettingActivity.class);
        intent.setData(uri);
        startActivity(intent);
    }

    @Override
    public void gotoSystemPhoto(int requestCode) {
        //跳转到调用系统图库
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media
                .EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "请选择图片"), requestCode);
    }

    @Override
    public void gotoSystemCamera(File tempFile, int requestCode) {
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //设置7.0中共享文件，分享路径定义在xml/file_paths.xml，下面2种方式都可以
            //            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            //            Uri contentUri = FileProvider.getUriForFile(mActivity, BuildConfig
            // .APPLICATION_ID + "" +
            //                    ".fileProvider", tempFile);
            //            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);

            ContentValues contentValues = new ContentValues(1);
            contentValues.put(MediaStore.Images.Media.DATA, tempFile
                    .getAbsolutePath());
            Uri uri = getContext().getContentResolver().insert(MediaStore.Images
                    .Media.EXTERNAL_CONTENT_URI, contentValues);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        mPresenter.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mPresenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return PersonalUpperPresenter.newInstance();
    }

    @Override
    public void initData() {
        super.initData();
        //        Logger.e("RxBus.get().register(this)");
        RxBus.get().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //        Logger.e("RxBus.get().unRegister(this)");
        RxBus.get().unRegister(this);
    }


    /**
     * RxBus接收图片Uri
     *
     * @param bean RxEventHeadBean
     */
    @Subscribe(code = RX_BUS_CODE_HEAD_IMAGE_URI)
    public void rxBusEvent(RxEventHeadBean bean) {
        Uri uri = bean.getUri();
        if (uri == null) {
            return;
        }
        String cropImagePath = FileUtils.getRealFilePathFromUri(AppUtils.getContext(), uri);
        Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);
        if (bitMap != null)
            civHead.setImageBitmap(bitMap);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_sign_in, R.id.tv_reg_in, R.id.rl_head,R.id.civ_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_sign_in:
                startNewActivity(LoginActivity.class);
                break;
            case R.id.tv_reg_in:
                startNewActivity(RegistActivity.class);
                break;
            case R.id.rl_head:
                break;
            case R.id.civ_head:
                mPresenter.btnHeadClicked();
                break;
        }
    }
}
