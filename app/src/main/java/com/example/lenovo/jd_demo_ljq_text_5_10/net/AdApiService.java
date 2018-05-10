package com.example.lenovo.jd_demo_ljq_text_5_10.net;



import com.example.lenovo.jd_demo_ljq_text_5_10.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AdApiService {
   
    @GET("ad/getAd")
    Observable<AdBean> getAd();
}
