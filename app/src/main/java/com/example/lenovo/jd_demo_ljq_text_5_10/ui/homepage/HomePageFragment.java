package com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import com.example.lenovo.jd_demo_ljq_text_5_10.R;
import com.example.lenovo.jd_demo_ljq_text_5_10.bean.AdBean;
import com.example.lenovo.jd_demo_ljq_text_5_10.bean.CatagoryBean;
import com.example.lenovo.jd_demo_ljq_text_5_10.component.DaggerHttpComponent;
import com.example.lenovo.jd_demo_ljq_text_5_10.module.HttpModule;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.base.BaseFragment;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.adapter.RvClassAdapter;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.adapter.RvRecommendAdapter;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.adapter.RvSecKillAdapter;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.contract.HomPageContract;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.presenter.HomePagePresenter;
import com.example.lenovo.jd_demo_ljq_text_5_10.utils.GlideImageLoader;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends BaseFragment<HomePagePresenter> implements HomPageContract.View {
    private Banner banner;
    private RecyclerView rvClass;
    private MarqueeView marqueeView;
    private RecyclerView rvSecKill;
    private RecyclerView rvRecommend;
    private ImageView ivZxing;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    //跑马灯
    @Override
    public void initView(View view) {
        marqueeView = view.findViewById(R.id.marqueeView);
        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是孙福生。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：sfsheng0322");
        info.add("4. 新浪微博：孙福生微博");
        info.add("5. 个人博客：sunfusheng.com");
        info.add("6. 微信公众号：孙福生");
        marqueeView.startWithList(info);

        banner = (Banner) view.findViewById(R.id.banner);
        rvClass = view.findViewById(R.id.rvClass);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        rvClass.setLayoutManager(gridLayoutManager);

        rvSecKill = view.findViewById(R.id.rvSecKill);
        //设置布局管理器
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        rvSecKill.setLayoutManager(gridLayoutManager1);

        //设置布局管理器
        rvRecommend = view.findViewById(R.id.rvRecommend);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        rvRecommend.setLayoutManager(gridLayoutManager2);

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());

        //二维码
        ivZxing = view.findViewById(R.id.ivZxing);


        //请求数据
        initData();
    }

    /**
     * 请求数据
     */
    private void initData() {
        mPresenter.getAd();
        mPresenter.getCatagory();
    }

    @Override
    public void getAdSuccess(AdBean adBean) {
        List<AdBean.DataBean> data = adBean.getData();
        List<String> images = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            images.add(data.get(i).getIcon());
        }
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();


        RvSecKillAdapter rvSecKillAdapter = new RvSecKillAdapter(getActivity(), adBean.getMiaosha().getList());
        rvSecKill.setAdapter(rvSecKillAdapter);

        RvRecommendAdapter rvRecommendAdapter = new RvRecommendAdapter(getActivity(), adBean.getTuijian().getList());
        rvRecommend.setAdapter(rvRecommendAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void getCatagorySuccess(CatagoryBean catagoryBean) {
        List<CatagoryBean.DataBean> data = catagoryBean.getData();
        RvClassAdapter adapter = new RvClassAdapter(getActivity(), data);
        rvClass.setAdapter(adapter);


    }
}
