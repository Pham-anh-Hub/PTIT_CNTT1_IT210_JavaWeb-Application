package BaiTapSession02.demo.model;

import java.util.Date;

public class Order {
    // mã đơn, tên sản phẩm, tổng tiền, ngày đặt dạng java.util.Date).
    private String order_id;
    private String product_name;
    private  double total_amount;
    private Date order_date;

    public Order() {
    }

    public Order(String order_id, String product_name, double total_amount, Date order_date) {
        this.order_id = order_id;
        this.product_name = product_name;
        this.total_amount = total_amount;
        this.order_date = order_date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
}
