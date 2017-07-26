package com.youdu.imoocsdk.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * <pre>
 *     author : fangzheng
 *     e-mail : 185849480@qq.com
 *     time   : 2017/07/20
 *     desc   :
 *     version: 1.0
 * </pre>
 *
 * @funtion 接收请求参数，生成Request对象
 */
public class CommonRequest {

    /**
     * 生成 post 请求
     *
     * @param url    请求url
     * @param params 请求参数
     * @return 返回一个创建好的request对象
     */
    public static Request createPostRequest(String url, RequestParams params) {

        FormBody.Builder formBuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                formBuilder.add(entry.getKey(), entry.getValue());
            }
        }

        FormBody formBody = formBuilder.build();
        return new Request.Builder().url(url).post(formBody).build();
    }

    /**
     * @param url
     * @param params
     * @return 返回一个Get类型的请求
     */
    public static Request createGetRequest(String url, RequestParams params) {

        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null) {
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }

        return new Request.Builder()
                .url(urlBuilder.substring(0, urlBuilder.length() - 1))
                .get().build();
    }
}
