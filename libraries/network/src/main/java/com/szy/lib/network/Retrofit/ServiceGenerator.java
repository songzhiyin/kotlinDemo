package com.szy.lib.network.Retrofit;


import android.util.Log;

import com.szy.lib.network.BuildConfig;
import com.szy.lib.network.Retrofit.Util.NetWorkUtils;
import com.szy.lib.network.Retrofit.factory.CustomGsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author binju
 * Created by bingju on 2017/1/4.
 */

public class ServiceGenerator {
    /**
     * ************除了修改整体域名地址之外还要修改对账部分的域名地址********************
     */
//    public static String BASE_URL = "https://mer.test.tebiemiao.cn";//测试环境
            public static String BASE_URL = "https://mer.tebiemiao.cn";//正式环境
    private static OkHttpClient.Builder httpClientBuilder = NetWorkUtils.getUnsafeOkHttpClient();
    private static Retrofit.Builder builder = new Retrofit.Builder();
    private static OnUpdateAddHeaderListener onUpdateAddHeaderListener;


    public static <S> S createService(Class<S> serviceClass) {
        httpClientBuilder.addNetworkInterceptor(new InterceptorAd());//添加自定义Interceptor
        httpClientBuilder.connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS);//设置超时时间

        /**打印OKHTTP的运行日志*/
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }
        /**打印OKHTTP的运行日志*/
        builder.baseUrl(BASE_URL);//设置url
        builder.addConverterFactory(CustomGsonConverterFactory.create());//设置解析类
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());//设置rxjava
        Retrofit retrofit = builder.client(httpClientBuilder.build()).build();
        return retrofit.create(serviceClass);
    }

    /**
     * 自定义Interceptor类，在类中添加需要header部分
     */
    private static class InterceptorAd implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String token = onUpdateAddHeaderListener != null && onUpdateAddHeaderListener.updateToken() != null ? onUpdateAddHeaderListener.updateToken() : "";
            request = request.newBuilder()
                    .method(request.method(), request.body())
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            if (BuildConfig.DEBUG) {
                Log.i("token",token);
            }
            return chain.proceed(request);
        }
    }

    public static void setOnUpdateAddHeaderListener(OnUpdateAddHeaderListener onUpdateAddHeaderListener) {
        ServiceGenerator.onUpdateAddHeaderListener = onUpdateAddHeaderListener;
    }

    public interface OnUpdateAddHeaderListener {
        String updateToken();
    }
}
