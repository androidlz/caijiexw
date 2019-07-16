package com.seventeenok.caijie.api;

import com.seventeenok.caijie.model.bean.LoginBean;
import com.seventeenok.caijie.model.bean.hometab.HomeTabBean;
import com.seventeenok.caijie.model.bean.hometab.TabFragmentBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JRCJApi {
    //今日财界
    public static final String HOST = "http://app.17ok.com/index.php/v19/";

    public static final String Login =  "cjvuser/login";

    public static String SMS_CODE = "cjvuser/smscode";//获取验证码

    public static String REG_USER = "cjvuser/reg";//注册

    public static String CHANGE_PHONE = "cjvuser/cpsmscode";//修改手机号

    public static String LOGIN_USER = "cjvuser/login";//登录
    
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST(LOGIN_USER)
    Observable<LoginBean> getLoginInfo(@Body RequestBody requestBody);
    
    //获去首页tab的数据
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("pro_index/nav")
    Observable<HomeTabBean> getHomeTab(@Body RequestBody requestBody);
    
    //获去首页tabfragment的数据
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("cjv5/video_nal")
    Observable<TabFragmentBean> getTabFragData(@Body RequestBody requestBody);
    
    public static String USER_INFO = "cjvuser/userinfo";//获取个人信息

    public static String USER_BIND = "cjvuser/bind";//三方登录绑定

    public static String FIND_PWD = "cjvuser/findpass";//找回密码

    public static String CHANGE_PWD = "cjvuser/changepass";//找回密码

    public static String REFRESH_TOKEN = "cjvuser/reflush";//刷新token

    public static String AVATOR_MODIFY = "cjvuser/headup";//修改头像

    public static String NICK_MODIFY ="cjvuser/changenick";//修改昵称

    public static String YZYZM ="cjvuser/cpsmscode";//改绑手机的验证验证码
}
