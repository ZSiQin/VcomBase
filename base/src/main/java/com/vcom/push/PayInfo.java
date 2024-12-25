package com.vcom.push;

/**
 * Created by bin on 18/4/18.
 */

public class PayInfo {
    private String order_id;
    private String order_name;
    /// 业务类型，0汽车票，
    private int busi_type;
    /// 订单金额
    private double order_price;
    /// 支付状态，4支付成功，6支付失败
    private int order_state;
    ///出票状态
    private String ticket_state;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public int getBusi_type() {
        return busi_type;
    }

    public void setBusi_type(int busi_type) {
        this.busi_type = busi_type;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public String getTicket_state() {
        return ticket_state;
    }

    public void setTicket_state(String ticket_state) {
        this.ticket_state = ticket_state;
    }
}
