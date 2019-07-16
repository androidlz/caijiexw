package com.seventeenok.caijie.model.home.tab;

import android.support.annotation.NonNull;

import com.seventeenok.caijie.api.JRCJApi;
import com.seventeenok.caijie.constant.ItemType;
import com.seventeenok.caijie.constant.MultipleFields;
import com.seventeenok.caijie.contract.home.tab.TabFragmentContract;
import com.seventeenok.caijie.model.bean.hometab.TabFragmentBean;
import com.seventeenok.caijie.model.multiplemodel.MultipleItemModel;
import com.seventeenok.caijie.util.RetrofitCreateHelper;
import com.zyw.horrarndoo.sdk.helper.RxHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

import static com.seventeenok.caijie.util.RetrofitCreateHelper.createRequestBody;

/**
 * Created by root on 2018/5/22.
 */

public class TabFragmentModel implements TabFragmentContract.ITabFragmentModel {
    @NonNull
    public static TabFragmentModel newInstance() {
        return new TabFragmentModel();
    }
    
    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        return null;
    }
    
    @Override
    public Observable<ArrayList<MultipleItemModel>> getNewsData(String cateId) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cate_id", cateId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return RetrofitCreateHelper.createApi(JRCJApi.class, JRCJApi.HOST)
                .getTabFragData(createRequestBody(jsonObject))
                .flatMap(new Function<TabFragmentBean,
                        ObservableSource<ArrayList<MultipleItemModel>>>() {
                    @Override
                    public Observable<ArrayList<MultipleItemModel>> apply
                            (TabFragmentBean tabFragmentBean) throws Exception {
                        return conver(tabFragmentBean);
                    }
                })
                .compose(RxHelper.<ArrayList<MultipleItemModel>>rxSchedulerHelper());
    }
    
    public Observable<ArrayList<MultipleItemModel>> conver(TabFragmentBean tabFragmentBean) {
        TabFragmentBean.BodyEntity tabFragmentBeanBody = tabFragmentBean.getBody();
        //创建一个要返回的observale
        ArrayList<MultipleItemModel> multipleItemModels = new ArrayList();
        //添加焦点图
        MultipleItemModel multipleItemModelFocus = MultipleItemModel.builder()
                .setField(MultipleFields.ITEM_TYPE, ItemType.BANNER)
                .setField(MultipleFields.BANNERS, tabFragmentBeanBody.getFocus())
                .build();
        multipleItemModels.add(multipleItemModelFocus);
        
        //添加具体新闻内容
        List<TabFragmentBean.BodyEntity.ListAllDataEntity> listAllData
                = tabFragmentBeanBody.getListAllData();
        for (int i = 0; i < listAllData.size(); i++) {
            //每一条新闻
            TabFragmentBean.BodyEntity.ListAllDataEntity listAllDataEntity = listAllData.get(i);
            //每一条新闻的视频信息 //先这样获去第零条  以后会改
            TabFragmentBean.BodyEntity.ListAllDataEntity.VideoListEntity videoListEntity
                    = listAllDataEntity.getVideo_list().get(0);
            
            //获取layout  设置类型
            int layout = Integer.parseInt(videoListEntity.getLayout());
            int type = 0;
            if (layout == 0) {
                type = ItemType.TEXT;
            } else if (layout == 1) {
                type = ItemType.TEXT_IMAGE;
            } else if (layout == 2 || layout == 5 || layout == 6) {
                type = ItemType.IMAGE;
            } else if (layout == 3) {
                type = ItemType.THREE_IMAGE;
            }
            MultipleItemModel multipleItemModelNews = MultipleItemModel.builder()
                    .setField(MultipleFields.ITEM_TYPE, type)
                    .setField(MultipleFields.TITLE, videoListEntity.getTitle())
                    .setField(MultipleFields.IMAGE_URL, videoListEntity.getCover())
                    .setField(MultipleFields.KEY_WORD, videoListEntity.getKword_list())
                    .build();
            multipleItemModels.add(multipleItemModelNews);
        }
        return Observable.just(multipleItemModels);
        
    }
}
