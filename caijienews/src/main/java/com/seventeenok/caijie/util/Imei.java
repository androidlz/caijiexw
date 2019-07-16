package com.seventeenok.caijie.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;


import java.util.UUID;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ShiQing on 2018/3/6 0006 16:20
 * Desc:
 */

public class Imei {
    
    //获取手机的唯一标识
    public static String getPhoneSign(Context context){
        StringBuilder deviceId = new StringBuilder();
        try {
            //IMEI（imei）
            TelephonyManager tm = (TelephonyManager) context.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
            String imei = tm.getDeviceId();
            if(!TextUtils.isEmpty(imei)){
                deviceId.append(imei);
                return deviceId.toString();
            }
            //序列号（sn）
            String sn = tm.getSimSerialNumber();
            if(!TextUtils.isEmpty(sn)){
                deviceId.append(sn);
                return deviceId.toString();
            }
            //如果上面都没有， 则生成一个id：随机码
            String uuid = getUUID(context);
            if(!TextUtils.isEmpty(uuid)){
                deviceId.append(uuid);
                return deviceId.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            deviceId.append(getUUID(context));
        }
        return deviceId.toString();
    }
    /**
     * 得到全局唯一UUID
     */
    private static String uuid;
    public static String getUUID(Context context){
        SharedPreferences mShare =  context.getApplicationContext().getSharedPreferences("uuid",MODE_PRIVATE);
        if(mShare != null){
            uuid = mShare.getString("uuid", "");
        }
        if(TextUtils.isEmpty(uuid)){
            uuid = UUID.randomUUID().toString();
            mShare.edit().putString("uuid",uuid).commit();
        }
        return uuid;
    }
}
