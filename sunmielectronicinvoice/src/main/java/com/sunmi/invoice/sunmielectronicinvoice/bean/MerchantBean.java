package com.sunmi.invoice.sunmielectronicinvoice.bean;

import java.util.List;

/**
 * User: highsixty
 * Date: 2020-03-27 14:13
 * email: gaolulin@sunmi.com
 */
public class MerchantBean {

    /**
     * 商户Id
     */
    private int sourceId = 0;

    /**
     * 订单交易日期(10位秒级时间戳)
     */
    private int tradeDate = 0;

    /**
     * 订单过期日期(10位秒级时间戳,超过这个日期就不能开发票,传0永远不过期)
     */
    private int expireDate = 0;

    /**
     * 软件商唯一确定一笔订单的流水号(不允许重复)
     */
    private String orderSn = "";

    private List<GoodsBean> goodsList;

    public MerchantBean() {
    }

    public MerchantBean(int sourceId, int tradeDate, int expireDate, String orderSn, List<GoodsBean> goodsList) {
        this.sourceId = sourceId;
        this.tradeDate = tradeDate;
        this.expireDate = expireDate;
        this.orderSn = orderSn;
        this.goodsList = goodsList;
    }


    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(int tradeDate) {
        this.tradeDate = tradeDate;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public List<GoodsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        this.goodsList = goodsList;
    }
}
