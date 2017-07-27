package com.youdu.imoocsdk.okhttp;

import com.youdu.imoocsdk.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * <pre>
 *     author : fangzheng
 *     e-mail : 185849480@qq.com
 *     time   : 2017/07/20
 *     desc   :
 *     version: 1.0
 *     function: 请求的发送，请求的参数，https的支持
 * </pre>
 */
public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        //设置超时时间
        clientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        clientBuilder.writeTimeout(TIME_OUT,TimeUnit.SECONDS);

        //允许重定向
        clientBuilder.followRedirects(true);

        //支持https
        clientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        clientBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(),HttpsUtils.initTrustManager());

        mOkHttpClient = clientBuilder.build();
    }

    /**
     * 发送一个请求
     * @param request
     * @param callback
     * @return call
     */
    public static Call sendRequest(Request request, Callback callback){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
        return call;
    }
}
