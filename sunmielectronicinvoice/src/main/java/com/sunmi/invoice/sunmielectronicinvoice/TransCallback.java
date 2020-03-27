package com.sunmi.invoice.sunmielectronicinvoice;

import com.sunmi.invoice.OrderDetail;

/**
 * User: highsixty
 * Date: 2020-03-26 18:13
 * email: gaolulin@sunmi.com
 */
public interface TransCallback {
    void onSucess(OrderDetail orderDetail);
    void onFail(OrderDetail orderDetail);
}
