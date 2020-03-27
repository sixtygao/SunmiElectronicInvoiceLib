package com.sunmi.invoice.sunmielectronicinvoice.bean;

/**
 * User: highsixty
 * Date: 2020-03-27 13:51
 * email: gaolulin@sunmi.com
 */
public class GoodsBean {

    /**
     * 商品名称
     */
    private String goodsName = "" ;

    /**
     * 商品规格型号(如果为空,请传:"")
     */
    private String attribute = "";

    /**
     * 单位(如果为空,请传:"")
     */
    private String unit = "" ;

    /**
     * 商品数量
     */
    private int quantity = 0 ;

    /**
     * 商品单价（)
     */
    private double price = 0;

    /**
     * 该商品开票金额(含税)
     */
    private double invoiceAmount = 0;

    /**
     * 税率(填写0-100的整数) 如:税率为5%时rate的值为5
     */
    private int rate = 0;

    /**
     * 商品统一税率编码
     */
    private String taxClassificationCode = "";

    /**
     * 优惠政策标识(0:不使用,1:使用)
     */
    private int preferentialPolicyFlag = 0;

    /**
     * 增值税特殊管理(preferentialPolicyFlag优惠政策标识位1时必填)
     */
    private String vatSpecialManage = "";

    /**
     * 零税率标识(0:非零税率,1:出口零税, 2:免税,3:不征税,4 普通)
     */
    private int zeroTaxFlag = 0 ;

    public GoodsBean(){

    }

    public GoodsBean(String goodsName, String attribute, String unit, int quantity, double price, double invoiceAmount, int rate, String taxClassificationCode, int preferentialPolicyFlag, String vatSpecialManage, int zeroTaxFlag) {
        this.goodsName = goodsName;
        this.attribute = attribute;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
        this.invoiceAmount = invoiceAmount;
        this.rate = rate;
        this.taxClassificationCode = taxClassificationCode;
        this.preferentialPolicyFlag = preferentialPolicyFlag;
        this.vatSpecialManage = vatSpecialManage;
        this.zeroTaxFlag = zeroTaxFlag;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getTaxClassificationCode() {
        return taxClassificationCode;
    }

    public void setTaxClassificationCode(String taxClassificationCode) {
        this.taxClassificationCode = taxClassificationCode;
    }

    public int getPreferentialPolicyFlag() {
        return preferentialPolicyFlag;
    }

    public void setPreferentialPolicyFlag(int preferentialPolicyFlag) {
        this.preferentialPolicyFlag = preferentialPolicyFlag;
    }

    public String getVatSpecialManage() {
        return vatSpecialManage;
    }

    public void setVatSpecialManage(String vatSpecialManage) {
        this.vatSpecialManage = vatSpecialManage;
    }

    public int getZeroTaxFlag() {
        return zeroTaxFlag;
    }

    public void setZeroTaxFlag(int zeroTaxFlag) {
        this.zeroTaxFlag = zeroTaxFlag;
    }
}
