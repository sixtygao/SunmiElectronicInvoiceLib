package com.sunmi.invoce.sdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.sunmi.invoice.OrderDetail;
import com.sunmi.invoice.sunmielectronicinvoice.SunmiElectronicInvoiceUtils;
import com.sunmi.invoice.sunmielectronicinvoice.TransCallback;
import com.sunmi.invoice.sunmielectronicinvoice.bean.GoodsBean;
import com.sunmi.invoice.sunmielectronicinvoice.bean.MerchantBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SunmiElectronicInvoiceUtils.getInstance().init(this);
    }

    public void test(View view) {
        Log.d(TAG, "test: ------------->");
        GoodsBean goodsBean = new GoodsBean("1111", "2222", "3333", 4, 5.0, 6.0, 7, "8888", 9, "aaaa", 10);
        MerchantBean merchantBean = new MerchantBean();
        merchantBean.setExpireDate(1111);
        merchantBean.setOrderSn("12345677");
        merchantBean.setSourceId(66666);
        merchantBean.setTradeDate(333333);
        List<GoodsBean> goodsBeans = new ArrayList<>();
        goodsBeans.add(goodsBean);
        merchantBean.setGoodsList(goodsBeans);
        final String list = JSON.toJSONString(merchantBean);
        Log.d(TAG, "test: ------------>" + list);
//        for(int i=0 ;i<5;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Log.d(TAG, "run: -------->"+Thread.currentThread().getName());
//
        OrderDetail orderDetail = new OrderDetail("123455", "123456", list);
//
        SunmiElectronicInvoiceUtils.getInstance().transOrder(MainActivity.this, orderDetail, new TransCallback() {

            @Override
            public void onSucess(OrderDetail orderDetail) {
                Log.d(TAG, "onSucess: ------------>" + orderDetail.getSign());
            }

            @Override
            public void onFail(OrderDetail orderDetail) {
                Log.d(TAG, "onFail: -------------->" + orderDetail.getSign());
            }
        });
//                }
//            }).start();
//    }


    }
}
