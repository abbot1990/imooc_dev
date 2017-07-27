package com.youdu.imooc_business.application;

import android.app.Application;

/**
 * <pre>
 *     author : fangzheng
 *     e-mail : 185849480@qq.com
 *     time   : 2017/07/16
 *     desc   :
 *     version: 1.0
 * </pre>
 * @function
 */
public class ImoocApplication extends Application {

    public static ImoocApplication mImoocApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mImoocApplication = this;
    }

    public static Application getInstance(){
        return mImoocApplication;
    }

    //用户信息 是否登录

}
