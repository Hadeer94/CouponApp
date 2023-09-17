package org.coupon.api.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@Embeddable
public class ConsumptionHistoryId implements Serializable {
    private String coupon_code;
    private long order_id;
    public ConsumptionHistoryId(String coupon_code,long order_id){
        System.out.println("hi from con");
        this.coupon_code = coupon_code;
        this.order_id  =order_id;
    }
    public ConsumptionHistoryId(){

    }
    @Override
    public int hashCode() {
        System.out.println("hash");
        return this.coupon_code.hashCode();
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public long getOrderId() {
        return order_id;
    }

    public void setOrderId(long order_id) {
        this.order_id = order_id;
    }
}
