package com.zyw.horrarndoo.sdk.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyw.horrarndoo.sdk.R;
import com.zyw.horrarndoo.sdk.utils.ScreenUtils;

import java.util.ArrayList;

public class BaseTitleBar extends FrameLayout implements View.OnClickListener {
    private LayoutInflater layoutInflater;
    private FrameLayout fgBarLeft;
    private ImageView ivBarLeft;
    private LinearLayout llBarRight;
    private TextView tvBarTitle;
    private Context context;
    public BaseTitleBar(Context context) {
        this(context, null);
        this.context=context;
    }

    public BaseTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.context=context;
        layoutInflater = ((AppCompatActivity) context).getLayoutInflater();
        layoutInflater.inflate(R.layout.layout_title_bar, this);
        fgBarLeft = findViewById(R.id.fgBarLeft);
        ivBarLeft = findViewById(R.id.ivBarLeft);
        llBarRight = findViewById(R.id.llBarRight);
        tvBarTitle = findViewById(R.id.tvBarTitle);
        initView(context);
        setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private void initView(Context context) {
        fgBarLeft.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        ((Activity) getContext()).finish();
    }


    public BaseTitleBar setText(String text) {
        tvBarTitle.setText(text);
        return this;
    }

    public RelativeLayout getRoot() {
        return ((RelativeLayout) getChildAt(0));
    }

    public BaseTitleBar setRootColor(String color) {
        setBackgroundColor(Color.parseColor(color));
        return this;
    }


    public BaseTitleBar setText(int id) {
        return setText(getContext().getString(id));
    }

    public FrameLayout getFgBarLeft() {
        return fgBarLeft;
    }

    public ImageView getIvBarLeft() {
        return ivBarLeft;
    }

    public TextView getTvBarTitle() {
        return tvBarTitle;
    }

    public BaseTitleBar setTextColor(String color) {
        tvBarTitle.setTextColor(Color.parseColor(color));
        return this;
    }

    public LinearLayout getLlBarRight() {
        return llBarRight;
    }

    public BaseTitleBar setLeftImage(int rid) {
        ivBarLeft.setImageResource(rid);
        return this;
    }

    private ViewGroup.LayoutParams itemLayoutParam;

    public BaseTitleBar addItemView(BaseTitleBar.TitleBarItemInfo info) {
        View view;
        if (info.getIid() != 0) {
            if (itemLayoutParam == null) {
                itemLayoutParam = new ViewGroup.LayoutParams(ScreenUtils.dp2px(context,20), ScreenUtils.dp2px(context,20));
            }
            ImageView iv = new ImageView(getContext());
            iv.setLayoutParams(itemLayoutParam);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(info.getIid());
            view=iv;
        } else {
            TextView tv = new TextView(getContext());
            tv.setText(info.getTitle());
            tv.setTextColor(Color.parseColor(info.getTvColor()));
            tv.setTextSize(info.getTvSize());
            view=tv;
        }
        llBarRight.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemOnClickListener!=null){
                    mOnItemOnClickListener.itemClick(llBarRight.getChildCount()-1);
                }
            }
        });

        return this;
    }

    public interface OnItemOnClickListener{
        void itemClick(int index);
    }
    private BaseTitleBar.OnItemOnClickListener mOnItemOnClickListener;

    public BaseTitleBar setOnItemOnClickListener(BaseTitleBar.OnItemOnClickListener onItemOnClickListener) {
        mOnItemOnClickListener = onItemOnClickListener;
        return this;
    }

    public BaseTitleBar addItemView(ArrayList<BaseTitleBar.TitleBarItemInfo> infos) {
        for (int i = 0; i < infos.size(); i++) {
            addItemView(infos.get(i));
        }
        return this;
    }


    public static class TitleBarItemInfo {
        private String title;
        private int iid;
        private boolean isLine;
        private String tvColor = "#666666";
        private float tvSize = 12;

        public BaseTitleBar.TitleBarItemInfo setTvColor(String tvColor) {
            this.tvColor = tvColor;
            return this;
        }

        public BaseTitleBar.TitleBarItemInfo setTvSize(float tvSize) {
            this.tvSize = tvSize;
            return this;
        }

        public float getTvSize() {
            return tvSize;
        }

        public String getTvColor() {
            return tvColor;
        }

        public String getTitle() {
            return title;
        }

        public BaseTitleBar.TitleBarItemInfo setTitle(String title) {
            this.title = title;
            return this;
        }


        public int getIid() {
            return iid;
        }

        public BaseTitleBar.TitleBarItemInfo setIid(int iid) {
            this.iid = iid;
            return this;
        }

        public boolean isLine() {
            return isLine;
        }

        public BaseTitleBar.TitleBarItemInfo setLine(boolean line) {
            isLine = line;
            return this;
        }
    }

}

