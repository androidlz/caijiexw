package com.seventeenok.caijie.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.WeakHashMap;

/**
 * Created by ShiQing on 2018/3/6 0006 18:01
 * Desc:
 */

public class RestRequest {
    static JSONObject mObjectHeader;
    static JSONObject mObjectBody ;
    static JSONObject mObjectParam;
    
    public RestRequest() {
        mObjectHeader = new JSONObject();
        mObjectBody = new JSONObject();
        mObjectParam = new JSONObject();
    }
    
    public String create(WeakHashMap weakHashMapHeader, WeakHashMap weakHashMapBody) {
        for (Object key : weakHashMapHeader.keySet()) {
            try {
                mObjectHeader.put((String) key, weakHashMapHeader.get(key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (Object key : weakHashMapBody.keySet()) {
            try {
                mObjectBody.put((String) key, weakHashMapBody.get(key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return toStringParam();
    }
    
    private static String toStringParam() {
        try {
            mObjectParam.put("header", mObjectHeader);
            mObjectParam.put("body", mObjectBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mObjectParam.toString();
    }
}
