// IMyAidlInterface.aidl
package com.sunmi.invoice;

// Declare any non-default types here with import statements
import com.sunmi.invoice.OrderDetail;

interface IMyAidlInterface {
    void onSuccess(in OrderDetail detail);
    void OnFail(in OrderDetail detail);
}
