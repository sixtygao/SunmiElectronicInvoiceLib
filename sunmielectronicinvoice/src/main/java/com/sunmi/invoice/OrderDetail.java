package com.sunmi.invoice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: highsixty
 * Date: 2020-03-26 13:46
 * email: gaolulin@sunmi.com
 */
public class OrderDetail implements Parcelable {

    /**
     * 签名,参考概述中请求公共参数说明
     */
    private String sign;

    /**
     * 商米提供的app_id
     */
    private String app_id  ;

    /**
     * 订单列表
     */
    private String list ;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public OrderDetail(String sign, String app_id, String list) {
        this.sign = sign;
        this.app_id = app_id;
        this.list = list;
    }

    protected OrderDetail(Parcel in) {
        sign = in.readString();
        app_id = in.readString();
        list = in.readString();
    }

    public static final Creator<OrderDetail> CREATOR = new Creator<OrderDetail>() {
        @Override
        public OrderDetail createFromParcel(Parcel in) {
            return new OrderDetail(in);
        }

        @Override
        public OrderDetail[] newArray(int size) {
            return new OrderDetail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sign);
        dest.writeString(app_id);
        dest.writeString(list);
    }
}
