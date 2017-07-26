package com.youdu.imooc_business.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youdu.imooc_business.R;
import com.youdu.imooc_business.activity.base.BaseActivity;
import com.youdu.imooc_business.view.fragment.HomeFragment;
import com.youdu.imooc_business.view.fragment.MessageFragment;
import com.youdu.imooc_business.view.fragment.MineFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private FragmentManager mFragmentManager;

    private RelativeLayout mHomeLayoutView;
    private RelativeLayout mPondLayoutView;
    private RelativeLayout mMessageLayoutView;
    private RelativeLayout mMineLayoutView;

    private TextView mHomeImageView;
    private TextView mMessageImageView;
    private TextView mMineImageView;

    private Fragment mHomeFragment;
    private Fragment mMessageFragment;
    private Fragment mMineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        initView();

        //默认fragment
        mFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        mHomeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();
        mHomeImageView.setBackgroundResource(R.drawable.comui_tab_home_selected);


    }

    //初始化view
    private void initView() {
        mHomeLayoutView = (RelativeLayout) findViewById(R.id.home_layout_view);
        mPondLayoutView = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mMessageLayoutView = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMineLayoutView = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mHomeLayoutView.setOnClickListener(this);
        mPondLayoutView.setOnClickListener(this);
        mMessageLayoutView.setOnClickListener(this);
        mMineLayoutView.setOnClickListener(this);

        mHomeImageView = (TextView) findViewById(R.id.home_image_view);
        mMessageImageView = (TextView) findViewById(R.id.message_image_view);
        mMineImageView = (TextView) findViewById(R.id.mine_image_view);
    }

    private void hideFragment(Fragment fragment, FragmentTransaction fragmentTransaction) {
        if (fragment == null) {
            return;
        }
        fragmentTransaction.hide(fragment);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.home_layout_view:

                mHomeImageView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                //mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageImageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineImageView.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout,mHomeFragment);
                }else{
                    fragmentTransaction.show(mHomeFragment);
                }


                break;
            case R.id.pond_layout_view:
                mHomeImageView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageImageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineImageView.setBackgroundResource(R.drawable.comui_tab_person);


                break;
            case R.id.message_layout_view:
                mHomeImageView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageImageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineImageView.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();

                    fragmentTransaction.add(R.id.content_layout,mMessageFragment);
                }else{
                    fragmentTransaction.show(mMessageFragment);
                }

                break;
            case R.id.mine_layout_view:
                mHomeImageView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageImageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineImageView.setBackgroundResource(R.drawable.comui_tab_person_selected);

                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout,mMineFragment);
                }else{
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
