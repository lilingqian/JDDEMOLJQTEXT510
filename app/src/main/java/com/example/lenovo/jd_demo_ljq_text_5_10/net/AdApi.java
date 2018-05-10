package com.example.lenovo.jd_demo_ljq_text_5_10.net;



import com.example.lenovo.jd_demo_ljq_text_5_10.bean.AdBean;

import io.reactivex.Observable;

public class AdApi {
    private static AdApi adApi;
    private AdApiService adApiService;

    private AdApi(AdApiService adApiService) {
        this.adApiService = adApiService;
    }

    public static AdApi getAdApi(AdApiService adApiService) {
        if (adApi == null) {
            adApi = new AdApi(adApiService);
        }
        return adApi;
    }

    public Observable<AdBean> getAd() {
        return adApiService.getAd();
    }
}
