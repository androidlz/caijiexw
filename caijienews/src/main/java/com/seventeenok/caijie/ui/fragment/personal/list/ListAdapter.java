package com.seventeenok.caijie.ui.fragment.personal.list;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.seventeenok.caijie.R;

import java.util.List;

/**
 * Created by ShiQing on 2018/3/7 0007 11:24
 * Desc:
 */

public class ListAdapter extends BaseMultiItemQuickAdapter<ListBean, BaseViewHolder> {
    public ListAdapter(List<ListBean> data) {
        super(data);
        addItemType(ListItemType.ITEM_NORMAL, R.layout.arrow_item_layout);
        addItemType(ListItemType.ITEM_AVATAR, R.layout.arrow_item_avatar);
        addItemType(ListItemType.ITEM_NORIGHT_CLICK, R.layout.arrow_item_noright);
    }

    @Override
    protected void convert(BaseViewHolder helper, ListBean item) {
        switch (helper.getItemViewType()) {
            case ListItemType.ITEM_NORMAL:
                helper.setText(R.id.tv_arrow_text, item.getText());
                Glide.with(mContext)
                        .load(item.getImageUrl())
                        .error(R.mipmap.head_portrait)
                        .into((ImageView) helper.getView(R.id.imgv_left));
                break;
            case ListItemType.ITEM_AVATAR:
                Glide.with(mContext)
                        .load(item.getImageUrl())
                        .error(R.mipmap.head_portrait)
                        .into((ImageView) helper.getView(R.id.img_arrow_avatar));
                helper.setText(R.id.tv_arrow_text_a, item.getText());
                break;
            case ListItemType.ITEM_NORIGHT_CLICK:
                helper.setText(R.id.tv_arrow_text, item.getText());
                Glide.with(mContext)
                        .load(item.getImageUrl())
                        .error(R.mipmap.head_portrait)
                        .into((ImageView) helper.getView(R.id.imgv_left));
                helper.setText(R.id.tv_arrow_value,item.getValue());
                break;
            default:
                break;
        }
    }
}
