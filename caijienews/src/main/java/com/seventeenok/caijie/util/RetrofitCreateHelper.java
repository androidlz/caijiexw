package com.seventeenok.caijie.util;


import com.zyw.horrarndoo.sdk.helper.okhttp.CacheInterceptor;
import com.zyw.horrarndoo.sdk.helper.okhttp.TrustManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Horrarndoo on 2017/9/7.
 * <p>
 */

public class RetrofitCreateHelper {
    private static final int TIMEOUT_READ = 20;
    private static final int TIMEOUT_CONNECTION = 10;
    private static final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static CacheInterceptor cacheInterceptor = new CacheInterceptor();



    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            //SSL证书
            .sslSocketFactory(TrustManager.getUnsafeOkHttpClient())
            .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
            //打印日志
            .addInterceptor(interceptor)
            //设置Cache拦截器
//            .addNetworkInterceptor(cacheInterceptor)
//            .addInterceptor(cacheInterceptor)
//            .cache(HttpCache.getCache())
            //time out
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            //失败重连
            .retryOnConnectionFailure(true)
//            .addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request original = chain.request();
//                    UserProfile userProfile = UserProfile.getUserProfile();
//                    // Request customization: add request headers
//                    Request.Builder requestBuilder = original.newBuilder()
//                            .addHeader("userid", userProfile.getUserId() + "")
//                            .addHeader("token", userProfile.getToken());
//                    Request request = requestBuilder.build();
//                    return chain.proceed(request);
//                }
//            })
//            .addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    LogUtils.e(chain.toString());
//                    return null;
//                }
//            })
            .build();

    public static <T> T createApi(Class<T> clazz, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

    public static RequestBody createRequestBody(JSONObject body){
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("body",body);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("jsonObject.toString()--->"+jsonObject.toString());
        
        RequestBody requestBody = RequestBody.create(MediaType
                .parse("application/json;charset=UTF-8"), jsonObject.toString());
        return requestBody;
    }
}

