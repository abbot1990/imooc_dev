package com.youdu.imooc_business.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.youdu.imooc_business.R;

public class BaseActivity extends AppCompatActivity {

    /**
     * 输出日志，所需tag
     */
    public String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        TAG = getComponentName().getShortClassName();

    }
}
