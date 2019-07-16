package com.seventeenok.caijie.ui.fragment.personal;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.seventeenok.caijie.R;
import com.seventeenok.caijie.ui.fragment.personal.child.WGLandFragment;
import com.seventeenok.caijie.ui.fragment.personal.list.ListAdapter;
import com.seventeenok.caijie.ui.fragment.personal.list.ListBean;
import com.seventeenok.caijie.ui.fragment.personal.list.ListItemType;
import com.seventeenok.caijie.ui.fragment.personal.list.SpaceItemDecoration;
import com.zyw.horrarndoo.sdk.base.fragment.BaseCompatFragment;
import com.zyw.horrarndoo.sdk.utils.DataCleanManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalLowerFragment extends BaseCompatFragment {

    @BindView(R.id.rv_personal)
    RecyclerView rv_personal;
    private List<ListBean> mData;
    private ListAdapter mAdapter;
    public static PersonalLowerFragment newInstance() {
        Bundle args = new Bundle();
        PersonalLowerFragment fragment = new PersonalLowerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PersonalLowerFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_lower;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
         //设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv_personal.setLayoutManager(manager);
        rv_personal.addItemDecoration(new SpaceItemDecoration(1));
        mData = new ArrayList<>();

    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        ListBean wg_land = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
                .setImageUrl(R.mipmap.xidalu)
                .setDelegate(new WGLandFragment())
                .setText(getString(R.string.per_wg_land))
                .build();
        ListBean myCollection = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setImageUrl(R.mipmap.personal_collection)
                .setText(getString(R.string.per_collection))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean look_record = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(3)
                .setImageUrl(R.mipmap.personal_record)
                .setText(getString(R.string.per_look))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean column = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(4)
                .setImageUrl(R.mipmap.personal_column)
                .setText(getString(R.string.per_column))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean news = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(5)
                .setImageUrl(R.mipmap.personal_push)
                .setText(getString(R.string.per_news))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean font_size = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(6)
                .setImageUrl(R.mipmap.personal_size)
                .setText(getString(R.string.per_font_size))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean share_friend = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(7)
                .setImageUrl(R.mipmap.personal_share)
                .setText(getString(R.string.per_share_friend))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean about_us = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(8)
                .setImageUrl(R.mipmap.personal_us)
                .setText(getString(R.string.per_about_us))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean night_mode = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(9)
                .setImageUrl(R.mipmap.personal_nocturnal)
                .setText(getString(R.string.per_night_mode))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean duty = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(10)
                .setImageUrl(R.mipmap.personal_statement)
                .setText(getString(R.string.per_duty))
                .setDelegate(new WGLandFragment())
                .build();
        ListBean clear = null;
        try {
            clear = new ListBean.Builder()
                    .setItemType(ListItemType.ITEM_NORIGHT_CLICK)
                    .setId(11)
                    .setImageUrl(R.mipmap.personal_del)
                    .setText(getString(R.string.per_clear_cache))
                    .setValue(DataCleanManager.getTotalCacheSize(getContext())+"")
                    .setDelegate(new WGLandFragment())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ListBean updapte = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORIGHT_CLICK)
                .setId(12)
                .setValue("v1.1.1")
                .setImageUrl(R.mipmap.personal_editioninfo)
                .setText(getString(R.string.per_update))
                .setDelegate(new WGLandFragment())
                .build();

        mData.clear();
        mData.add(wg_land);
        mData.add(myCollection);
        mData.add(look_record);
        mData.add(column);
        mData.add(news);
        mData.add(font_size);
        mData.add(share_friend);
        mData.add(about_us);
        mData.add(night_mode);
        mData.add(duty);
        mData.add(clear);
        mData.add(updapte);

//        mData.add(upData);
        if (mAdapter == null) {
            mAdapter = new ListAdapter(mData);
            rv_personal.setAdapter(mAdapter);
            rv_personal.addOnItemTouchListener(new PeronalClickListener(this));
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    //清除缓存后  刷新条目
    public void clearCache(){
        ListBean clear = null;
        try {
            clear = new ListBean.Builder()
                    .setItemType(ListItemType.ITEM_NORIGHT_CLICK)
                    .setId(11)
                    .setImageUrl(R.mipmap.personal_del)
                    .setText(getString(R.string.per_clear_cache))
                    .setValue(0+"M")
                    .setDelegate(new WGLandFragment())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mData.set(10,clear);
        mAdapter.notifyItemChanged(10);
    }
}
