package com.yu.yuframe.test;

import android.os.Bundle;
import android.util.Log;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;
import com.yu.yuframe.util.test.DeviceUuidFactory;

import java.util.UUID;

/**
 * 判断设备唯一性工具测试类
 * Created by Yu on 2016/4/15.
 * Email:zhaoshiyu900310@163.com
 */
public class DeviceUuidFactoryTestActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_device_uuid_factory_test_activity);
        UUID uuid = new DeviceUuidFactory(this).getDeviceUuid();
        Log.d("DeviceUuidFactoryTestAc", "uuid:" + uuid);
    }
}
