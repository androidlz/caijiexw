package com.seventeenok.caijie.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.seventeenok.caijie.R;
import com.seventeenok.caijie.ui.fragment.home.HomeRootFragment;
import com.seventeenok.caijie.ui.fragment.personal.PersonalRootFragment;
import com.seventeenok.caijie.ui.fragment.video.VideoFragment;
import com.seventeenok.caijie.ui.fragment.zbt.ZbtFragment;
import com.zyw.horrarndoo.sdk.base.activity.BaseCompatActivity;
import com.zyw.horrarndoo.sdk.rxbus.RxBus;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Horrarndoo on 2017/9/7.
 * <p>
 * 主页activity
 */

public class MainActivity extends BaseCompatActivity {


    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.rb_news)
    RadioButton rbNews;
    @BindView(R.id.rb_video)
    RadioButton rbVideo;
    @BindView(R.id.rb_zbt)
    RadioButton rbZbt;
    @BindView(R.id.rb_personal)
    RadioButton rbPersonal;
    @BindView(R.id.rg)
    RadioGroup rg;

    private SupportFragment[] mFragments = new SupportFragment[4];

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mFragments[FIRST] = HomeRootFragment.newInstance();
            mFragments[SECOND] = VideoFragment.newInstance();
            mFragments[THIRD] = ZbtFragment.newInstance();
            mFragments[FOURTH] = PersonalRootFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()
            // 自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(HomeRootFragment.class);
            mFragments[SECOND] = findFragment(VideoFragment.class);
            mFragments[THIRD] = findFragment(ZbtFragment.class);
            mFragments[FOURTH] = findFragment(PersonalRootFragment.class);
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_news:
                        showHideFragment(mFragments[FIRST]);
                        break;
                    case R.id.rb_video:
                        showHideFragment(mFragments[SECOND]);
                        break;
                    case R.id.rb_zbt:
                        showHideFragment(mFragments[THIRD]);
                        break;
                    case R.id.rb_personal:
                        showHideFragment(mFragments[FOURTH]);
                        break;
                }
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initData() {
        super.initData();
        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unRegister(this);
    }
}
