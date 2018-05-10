package com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.contract;


import com.example.lenovo.jd_demo_ljq_text_5_10.bean.AdBean;
import com.example.lenovo.jd_demo_ljq_text_5_10.bean.CatagoryBean;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.base.BaseContract;

public interface HomPageContract {
    interface View extends BaseContract.BaseView {
        void getAdSuccess(AdBean adBean);

        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getAd();

        void getCatagory();
    }

}
