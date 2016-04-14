package com.yu.yuframe.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rey.material.app.BottomSheetDialog;
import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.TimePickerDialog;
import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yu on 2016/4/15.
 * Email:zhaoshiyu900310@163.com
 */
public class MaterialDesignRey5173_Test extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_materialdesign_rey5173_test);
    }
    /**
     * 从下往上的dialog
     * @param view
     */
    public void bottomToTop(View view) {
        new BottomSheetDialog(this).contentView(R.layout.test_materialdesign_rey5173_test_dialog_bttop).show();
    }
    /**
     * dialog获取日期
     * @param view
     */
    public void dateDialog(View view) {
        //new DatePickerDialog()
        Calendar instance = Calendar.getInstance();
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int month = instance.get(Calendar.MONTH);
        int year = instance.get(Calendar.YEAR);

        DatePickerDialog dialog = (DatePickerDialog) new DatePickerDialog.Builder().date(day, month, year).dateRange(1, 0, 1900, 31, 11, 2100).title("时间设置").build(this);
        dialog.onDateChangedListener(new DatePickerDialog.OnDateChangedListener() {
            @Override
            public void onDateChanged(int oldDay, int oldMonth, int oldYear, int newDay, int newMonth, int newYear) {
                Log.i("info", "d:" + oldDay + "\tm:" + oldMonth + "\ty:" + oldYear);
                Log.i("info","d:"+newDay+"\tm:"+newMonth+"\ty:"+newYear);
            }
        });
        dialog.show();

    }


    /**
     * 获取时间
     * @param view
     */
    public void timeDialog(View view) {

        Date date = new Date();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        //int seconds = date.getSeconds();
        TimePickerDialog timePicker = (TimePickerDialog) new TimePickerDialog.Builder().hour(hours).minute(minutes).title("时间").build(this);

        timePicker.onTimeChangedListener(new TimePickerDialog.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(int oldHour, int oldMinute, int newHour, int newMinute) {
                Log.i("info", "hour:" + newHour + "\tminute:" + newMinute);
            }
        });
        timePicker.show();
        //new TimePickerDialog(this,this,hours,minutes,true).show();
    }
}
