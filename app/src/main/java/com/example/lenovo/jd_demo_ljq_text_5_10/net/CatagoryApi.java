package com.example.lenovo.jd_demo_ljq_text_5_10.net;



import com.example.lenovo.jd_demo_ljq_text_5_10.bean.CatagoryBean;

import io.reactivex.Observable;

public class CatagoryApi {
    private static CatagoryApi catagoryApi;
    private CatagoryApiService catagoryApiService;

    private CatagoryApi(CatagoryApiService catagoryApiService) {
        this.catagoryApiService = catagoryApiService;
    }

    public static CatagoryApi getCatagoryApi(CatagoryApiService catagoryApiService) {
        if (catagoryApi == null) {
            catagoryApi = new CatagoryApi(catagoryApiService);
        }
        return catagoryApi;
    }

    public Observable<CatagoryBean> getCatagory() {
        return catagoryApiService.getCatagory();
    }
}
