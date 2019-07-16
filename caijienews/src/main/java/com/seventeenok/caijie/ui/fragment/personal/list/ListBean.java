package com.seventeenok.caijie.ui.fragment.personal.list;

import android.widget.CompoundButton;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * Created by ShiQing on 2018/3/7 0007 11:23
 * Desc:
 */

public class ListBean implements MultiItemEntity {
    
    private int mItemType = 0;
    private int mImageUrl = 0;
    private String mText = null;
    private String mValue = null;
    private int mId = 0;
    private ISupportFragment mDelegate = null;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = null;
    
    public ListBean(int mItemType, int mImageUrl, String mText, String mValue, int mId, ISupportFragment mDelegate, CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener) {
        this.mItemType = mItemType;
        this.mImageUrl = mImageUrl;
        this.mText = mText;
        this.mValue = mValue;
        this.mId = mId;
        this.mDelegate = mDelegate;
        this.mOnCheckedChangeListener = mOnCheckedChangeListener;
    }
    
    public int getImageUrl() {
        return mImageUrl;
    }
    
    public String getText() {
        if (mText == null) {
            return "";
        }
        return mText;
    }
    
    public String getValue() {
        if (mValue == null) {
            return "";
        }
        return mValue;
    }
    
    public int getId() {
        return mId;
    }
    
    public ISupportFragment getDelegate() {
        return mDelegate;
    }
    
    public CompoundButton.OnCheckedChangeListener getmOnCheckedChangeListener() {
        return mOnCheckedChangeListener;
    }
    
    @Override
    public int getItemType() {
        return mItemType;
    }
    
    public static final class Builder {
        
        private int id = 0;
        private int itemType = 0;
        private int imageUrl = 0;
        private String text = null;
        private String value = null;

        private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = null;
        private ISupportFragment delegate = null;
        
        public Builder setId(int id) {
            this.id = id;
            return this;
        }
        
        public Builder setItemType(int itemType) {
            this.itemType = itemType;
            return this;
        }
        
        public Builder setImageUrl(int imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }
        
        public Builder setText(String text) {
            this.text = text;
            return this;
        }
        
        public Builder setValue(String value) {
            this.value = value;
            return this;
        }
        
        public Builder setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            this.onCheckedChangeListener = onCheckedChangeListener;
            return this;
        }
        
        public Builder setDelegate(ISupportFragment delegate) {
            this.delegate = delegate;
            return this;
        }


        
        public ListBean build() {
            return new ListBean(itemType, imageUrl, text, value, id, delegate, onCheckedChangeListener);
        }

    }
}
