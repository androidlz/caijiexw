package com.seventeenok.caijie.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.seventeenok.caijie.model.multiplemodel.MultipleItemModel;
import com.seventeenok.caijie.ui.widgets.RvLoadMoreView;

import java.util.List;

/**
 * Created by Horrarndoo on 2017/9/20.
 * <p>
 */

public abstract class BaseCompatAdapter<T extends MultipleItemModel, K extends BaseViewHolder> extends BaseMultiItemQuickAdapter<T,
        K> {

    public BaseCompatAdapter(@Nullable List<T> data) {
        super(data);
        init();
    }

    private void init(){
        setLoadMoreView(new RvLoadMoreView());
        setEnableLoadMore(true);
        openLoadAnimation();//开启默认动画载入（仅开启加载新item时开启动画）
    }
}
