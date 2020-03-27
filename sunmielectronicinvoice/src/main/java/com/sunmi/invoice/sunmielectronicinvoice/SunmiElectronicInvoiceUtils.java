package com.sunmi.invoice.sunmielectronicinvoice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.sunmi.invoice.IMyAidlInterface;
import com.sunmi.invoice.ISunmiElectronicInvoice;
import com.sunmi.invoice.OrderDetail;

/**
 * User: highsixty
 * Date: 2020-03-26 14:26
 * email: gaolulin@sunmi.com
 */
public class SunmiElectronicInvoiceUtils {

    public final static String TAG = SunmiElectronicInvoiceUtils.class.getSimpleName();

    /**
     * 是否打印日志
     */
    public static boolean DEBUG = true;

    public static SunmiElectronicInvoiceUtils utils = null;

    private ISunmiElectronicInvoice bindService = null;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            print("onServiceConnected: -------->");
            bindService = ISunmiElectronicInvoice.Stub.asInterface(service);
            if (null != bindService) {
                try {
                    bindService.asBinder().linkToDeath(new IBinder.DeathRecipient() {
                        @Override
                        public void binderDied() {
                            print("binderDied: ---------->");
                            if (null != bindService) {
                                bindService = null;
                            }

                        }
                    }, 0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    print("linkToDeath error: ----------->" + e.getMessage());
                }
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            print("onServiceDisconnected: -------->");
            if (null != bindService) {
                bindService = null;
            }
        }
    };

    private SunmiElectronicInvoiceUtils() {

    }

    public static SunmiElectronicInvoiceUtils getInstance() {

        synchronized (SunmiElectronicInvoiceUtils.class) {
            if (null == utils) {
                utils = new SunmiElectronicInvoiceUtils();
            }
        }

        return utils;
    }

    /**
     * bind 服务
     * @param context
     */
    public void init(Context context) {
        if(null==utils){
            throw new RuntimeException("please call getInstance method before!");
        }
        boolean reuslt = false;
        Intent intent = new Intent("com.sunmi.invoice.transferorderdetail");
        intent.setPackage("com.sunmi.invoice.shu");
        reuslt = context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        print("bind shu result--->"+reuslt);
        if (!reuslt) {
            intent.setPackage("com.sunmi.invoice.heng");
            reuslt = context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        }
        print("bind result---->" + reuslt);

    }


    /**
     * 传输订单信息
     * @param context
     * @param detail 订单
     * @param callback 回调
     */
    public void transOrder(Context context, OrderDetail detail, final TransCallback callback) {
        if(null==utils){
            throw new RuntimeException("please call getInstance method before!");
        }
        print(detail.getSign());
        if (null != bindService) {
            try {
                bindService.transOrder(detail, new IMyAidlInterface.Stub() {
                    @Override
                    public void onSuccess(OrderDetail detail) throws RemoteException {
                        if (null != callback) {
                            callback.onSucess(detail);
                        }
                    }

                    @Override
                    public void OnFail(OrderDetail detail) throws RemoteException {
                        if (null != callback) {
                            callback.onFail(detail);
                        }
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
                print(e.getMessage());
                if (null != callback) {
                    callback.onFail(detail);
                }
            }
        } else {
            //重新绑定服务
            init(context);
            if (null != callback) {
                callback.onFail(detail);
            }
        }
    }

    /**
     * 控制日志打印
     *
     * @param msg
     */
    private void print(String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

}
