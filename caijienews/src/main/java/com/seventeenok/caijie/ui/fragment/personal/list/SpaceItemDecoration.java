package com.seventeenok.caijie.ui.fragment.personal.list;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
//        outRect.right = mSpace;
//        outRect.left = mSpace;
        outRect.bottom = mSpace;
//        if (parent.getChildAdapterPosition(view) == 0 && parent.getChildAdapterPosition(view) == 1) {
//            outRect.top = mSpace;
//        }
//        if (parent.getChildAdapterPosition(view) % 2 == 0) {
//            outRect.right = mSpace / 2;
//        }
//        if (parent.getChildAdapterPosition(view) % 2 == 1) {
//            outRect.left = mSpace / 2;
//        }
        view.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }
}