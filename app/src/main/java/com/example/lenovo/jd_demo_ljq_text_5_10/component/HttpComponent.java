package com.example.lenovo.jd_demo_ljq_text_5_10.component;



import com.example.lenovo.jd_demo_ljq_text_5_10.module.HttpModule;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.HomePageFragment;
import com.example.lenovo.jd_demo_ljq_text_5_10.ui.login.LoginActivity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(LoginActivity loginActivity);

    void inject(HomePageFragment homePageFragment);
}
