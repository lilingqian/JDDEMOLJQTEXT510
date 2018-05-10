package com.example.lenovo.jd_demo_ljq_text_5_10.ui.login.contract;


import com.example.lenovo.jd_demo_ljq_text_5_10.bean.UserBean;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.base.BaseContract;

public interface LoginContract {
    interface View extends BaseContract.BaseView {
        void loginSuccess(UserBean userBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String mobile, String password);
    }
}
