package com.yu.yuframe.test;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import zxing.activity.CaptureActivity;
import zxing.encoding.EncodingHandler;

/**
 * Created by Yu on 2016/4/13.
 * Zxing二维码扫描,及二维码生成
 */
public class BarCodeTest extends BaseActivity {
    private TextView resultTextView;
    private EditText qrStrEditText;
    private ImageView qrImgImageView;
    Button scanBarCodeButton;
    Button generateQRCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        resultTextView = (TextView) this.findViewById(R.id.tv_scan_result);

        qrStrEditText = (EditText) this.findViewById(R.id.et_qr_string);

        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);

        //扫描二维码
        scanBarCodeButton = (Button) this.findViewById(R.id.btn_scan_barcode);

        scanBarCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //打开扫描界面扫描条形码或二维码
                Intent openCameraIntent = new Intent(getApplicationContext(),
                        CaptureActivity
                                .class);
                startActivityForResult(openCameraIntent, 0);
            }
        });


        //生成二维码
        generateQRCodeButton = (Button) this.findViewById(R.id.btn_add_qrcode);
        generateQRCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    String contentString = qrStrEditText.getText().toString();
                    if (!contentString.equals("")) {
                        //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                        Bitmap qrCodeBitmap = EncodingHandler.createQRCode
                                (contentString, 350);
                        qrImgImageView.setImageBitmap(qrCodeBitmap);
                    } else {
                        Toast.makeText(getApplicationContext(), "Text can not" +
                                " be empty", Toast
                                .LENGTH_SHORT).show();
                    }

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        //处理扫描结果（在界面上显示）
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            resultTextView.setText(scanResult);
        }
    }

}

