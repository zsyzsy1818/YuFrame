package com.yu.yuframe.testmain;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.yu.yuframe.R;
import com.yu.yuframe.bean.test.QsTextEntityTest;
import com.yu.yuframe.ui.BaseActivity;
import com.yu.yuframe.uri.test.AppInterTest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yu on 2016/4/13.
 * 网络访问实例(未完成图片,视频 获取)
 */
public class Retrofit_Test extends BaseActivity {

    private TextView testretrofittvId;
    private ImageView testretrofitivId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_retrofit);
        this.testretrofitivId = (ImageView) findViewById(R.id
                .test_retrofit_ivId);
        this.testretrofittvId = (TextView) findViewById(R.id
                .test_retrofit_tvId);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //这个是测试的AppInterTest
        AppInterTest appInter = retrofit.create(AppInterTest.class);
        //定义请求

        //参数:1 是page传入的参数
        Call<QsTextEntityTest> qsTextEntityTest = appInter.getQsTextEntity(1);


        //执行请求
        qsTextEntityTest.enqueue(new Callback<QsTextEntityTest>() {
            @Override
            public void onResponse(Call<QsTextEntityTest> call,
                                   Response<QsTextEntityTest> response) {
                QsTextEntityTest qsTextEntity1Test = response.body();
                Log.i("info", qsTextEntity1Test.getItems().get(0).getContent());

                testretrofittvId.setText(qsTextEntity1Test.getItems().get(0).getContent());

                    Log.d("Retrofit_Test", qsTextEntity1Test
                            .getItems().get(0).getUser().getIcon());


            }

            @Override
            public void onFailure(Call<QsTextEntityTest> call, Throwable t) {

            }
        });
    }
}
