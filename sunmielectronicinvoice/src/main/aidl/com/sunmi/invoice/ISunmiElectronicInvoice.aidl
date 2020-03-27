// IMyAidlInterface.aidl
package com.sunmi.invoice;

// Declare any non-default types here with import statements

import com.sunmi.invoice.OrderDetail;
import com.sunmi.invoice.IMyAidlInterface;



interface ISunmiElectronicInvoice {
 
    void transOrder(in OrderDetail detail , in IMyAidlInterface callback);
}
