package com.example.wo.travelt.core;

import com.example.wo.travelt.bean.SceneImgVo;

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
    Observable<String> login(@Field("name") String name, @Field("psw") String psw);

    //登录
    @FormUrlEncoded
    @POST("Register")
    Observable<String> register(@Field("name") String name, @Field("passwd") String psw, @Field("phone") String phone);

    //登录
    @FormUrlEncoded
    @POST("BannerSceneServlet")
    Observable<SceneImgVo> getScene();

}
