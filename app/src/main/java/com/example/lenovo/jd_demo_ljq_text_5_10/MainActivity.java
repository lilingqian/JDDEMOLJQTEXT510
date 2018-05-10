package com.example.lenovo.jd_demo_ljq_text_5_10;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.lenovo.jd_demo_ljq_text_5_10.fragmnet.FiveFragment;
import com.example.lenovo.jd_demo_ljq_text_5_10.fragmnet.FourFragment;
import com.example.lenovo.jd_demo_ljq_text_5_10.fragmnet.ThreeFragment;
import com.example.lenovo.jd_demo_ljq_text_5_10.fragmnet.TwoFragment;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.HomePageFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends FragmentActivity {

    private FrameLayout mFl;
    private BottomTabBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        HomePageFragment homePageFragment = new HomePageFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fl, homePageFragment)
                .commit();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏

        mBottomBar = findViewById(R.id.bottom_bar);


        mBottomBar.init(getSupportFragmentManager(), 720, 1280)
                .setImgSize(60, 60)
                .addTabItem("首页", R.mipmap.shouyetwo, R.mipmap.shouyeone, HomePageFragment.class)
                .addTabItem("分类", R.mipmap.feileitwo,R.mipmap.fenleione, TwoFragment.class)
                .addTabItem("发现", R.mipmap.faxiantwo,R.mipmap.faxianone, ThreeFragment.class)
                .addTabItem("购物车", R.mipmap.gouwuchetwo,R.mipmap.houwuchethree, FourFragment.class)
                .addTabItem("我的", R.mipmap.wodetwo,R.mipmap.wodeone, FiveFragment.class)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        if (position == 1)
                            mBottomBar.setSpot(1, false);
                    }
                })
                .setSpot(1, true)
                .setSpot(2, true);
    }



    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.fl);
    }
}
