package com.seventeenok.caijie.ui.fragment.personal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.seventeenok.caijie.ui.fragment.personal.list.ListBean;
import com.zyw.horrarndoo.sdk.utils.DataCleanManager;

import me.yokeyword.fragmentation.SupportFragment;

public class PeronalClickListener extends SimpleClickListener {
    PersonalLowerFragment DELEGATE;

    public PeronalClickListener(PersonalLowerFragment DELEGATE) {
        this.DELEGATE = DELEGATE;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final ListBean bean = (ListBean) baseQuickAdapter.getData().get(position);
        final int id = bean.getId();
        if(id==11){
            //清理缓存
            huancun();
        }else{
            ((SupportFragment) DELEGATE.getParentFragment()).getSupportDelegate().start(bean.getDelegate());
        }

    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
    private void huancun() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DELEGATE.getContext());
        AlertDialog alertDialog = builder.setMessage("确定清除本地缓存吗?")
                .setTitle("提示")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //清除本地缓存
                        DataCleanManager.clearAllCache(DELEGATE.getContext());
                        DELEGATE.clearCache();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create();
        alertDialog.show();

    }
}
