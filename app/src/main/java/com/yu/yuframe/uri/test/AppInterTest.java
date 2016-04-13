package com.yu.yuframe.uri.test;

import com.yu.yuframe.bean.test.QsTextEntityTest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Yu on 2016/4/13.
 *
 * 网络请求测试类
 *  http://m2.qiushibaike.com/article/list/text?page=%d
 */
public interface AppInterTest {
    //get请求
    @GET("/article/list/text?")
    Call<QsTextEntityTest> getQsTextEntity(@Query("page") int page);
    //post请求
    @POST("/article/list/text")
    Call<QsTextEntityTest> getQs(@Field("username") String username, @Field("password")String password , @FieldMap Map<String,String> maps);

}
