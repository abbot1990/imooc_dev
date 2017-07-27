package com.youdu.imooc_business.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youdu.imooc_business.R;

public class MineFragment extends BaseFragment {

    public MineFragment() {
        // Required empty public constructor
      //test 2
      Log.i(TAG, "MineFragment: ");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine_layout, container, false);
    }


}
