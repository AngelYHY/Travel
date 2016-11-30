package com.example.wo.travelt.core;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by freestar on 2016/11/3.
 */

public interface RetrofitService {
    //登录
    @FormUrlEncoded
    @POST("Login")
    Observable<String> login(@Field("name") String name, @Field("passwd") String passwd);

}
