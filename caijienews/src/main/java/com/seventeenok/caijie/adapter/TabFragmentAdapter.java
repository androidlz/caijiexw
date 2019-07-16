package com.seventeenok.caijie.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.seventeenok.caijie.R;
import com.seventeenok.caijie.adapter.holder.MultipleViewHolder;
import com.seventeenok.caijie.constant.ItemType;
import com.seventeenok.caijie.constant.MultipleFields;
import com.seventeenok.caijie.model.bean.hometab.TabFragmentBean;
import com.seventeenok.caijie.model.multiplemodel.MultipleItemModel;
import com.zyw.horrarndoo.sdk.utils.ScreenUtils;
import com.zyw.horrarndoo.sdk.widgets.slider.Indicators.PagerIndicator;
import com.zyw.horrarndoo.sdk.widgets.slider.SliderLayout;
import com.zyw.horrarndoo.sdk.widgets.slider.SliderTypes.BaseSliderView;
import com.zyw.horrarndoo.sdk.widgets.slider.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

import static com.seventeenok.caijie.constant.MultipleFields.KEY_WORD;

/**
 * Created by root on 2018/5/22.
 */

public class TabFragmentAdapter extends BaseCompatAdapter<MultipleItemModel, MultipleViewHolder> {
    
    //确保初始化一次Banner，防止重复Item加载
    private boolean mIsInitBanner = false;
    
    public TabFragmentAdapter(@Nullable List<MultipleItemModel> data) {
        super(data);
        init();
    }
    
    private void init() {
        //设置不同的item布局
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner);
        
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_image_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.THREE_IMAGE, R.layout.item_multiple_three_image);
        openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        //多次执行动画
        isFirstOnly(false);
    }
    
    @Override
    protected MultipleViewHolder createBaseViewHolder(View view) {
        return MultipleViewHolder.create(view);
    }
    
    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemModel entity) {
        String title = null;
        List<TabFragmentBean.BodyEntity.ListAllDataEntity.VideoListEntity.KwordListEntity>
                kwordListEntity = null;
        ArrayList<String> covers = null;
        holder.itemView.setTag(holder);
        if (holder.getItemViewType() != ItemType.BANNER) {
            title = entity.getField(MultipleFields.TITLE);
            kwordListEntity = entity.getField(KEY_WORD);
            covers = entity.getField(MultipleFields.IMAGE_URL);
            if (title != null) {
                holder.setText(R.id.item_title, title);
            }
            if (kwordListEntity != null && kwordListEntity.size() > 0) {
                holder.setText(R.id.item_editor, kwordListEntity.get(0).getCate_name());
            }
        }
        switch (holder.getItemViewType()) {
            case ItemType.BANNER:
                if (!mIsInitBanner) {
                    List<TabFragmentBean.BodyEntity.FocusEntity> focusEntities = entity.getField(MultipleFields.BANNERS);
                    SliderLayout sliderLayout = holder.getView(R.id.vp_banner);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) sliderLayout.getLayoutParams();
                    params.height = (int) ((ScreenUtils.getScreenWidth(mContext) - ScreenUtils.dp2px(mContext, 20)) * 0.5625);
                    sliderLayout.setLayoutParams(params);
                    if (focusEntities.size() == 0) {
                        sliderLayout.setVisibility(View.GONE);
                    }
                    PagerIndicator pagerIndicator = holder.getView(R.id.custom_indicator);
                    for (final TabFragmentBean.BodyEntity.FocusEntity focusBean : focusEntities) {
                        TextSliderView textSliderView = new TextSliderView(mContext);
                        textSliderView
                                .description(focusBean.getTitle())
                                .image(focusBean.getImg())
                                .setScaleType(BaseSliderView.ScaleType.Fit)
                                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                                    @Override
                                    public void onSliderClick(BaseSliderView slider) {
                                        
                                    }
                                });
                        textSliderView.bundle(new Bundle());
                        textSliderView.getBundle().putString("extra", focusBean.getTitle());
                        sliderLayout.addSlider(textSliderView);
                        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomIn);
                        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
                        sliderLayout.setCustomIndicator(pagerIndicator);
                        sliderLayout.setDuration(4000);
                    }
                    mIsInitBanner = true;
                }
                break;
            case ItemType.TEXT:
                break;
            case ItemType.TEXT_IMAGE:
                Glide.with(mContext)
                        .load(covers.get(0))
                        .into((ImageView) holder.getView(R.id.item_imgv_text_imgv));
                break;
            case ItemType.IMAGE:
                Glide.with(mContext)
                        .load(covers.get(0))
                        .into((ImageView) holder.getView(R.id.item_image_imgv));
                break;
            case ItemType.THREE_IMAGE:
                Glide.with(mContext)
                        .load(covers.get(0))
                        .into((ImageView) holder.getView(R.id.imgv1));
                Glide.with(mContext)
                        .load(covers.get(1))
                        .into((ImageView) holder.getView(R.id.imgv2));
                Glide.with(mContext)
                        .load(covers.get(2))
                        .into((ImageView) holder.getView(R.id.imgv3));
                break;
            default:
                break;
        }
    }
}
