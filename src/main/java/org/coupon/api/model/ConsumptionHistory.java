package org.coupon.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "consumption_history")
public class ConsumptionHistory {
    @EmbeddedId
    public ConsumptionHistoryId consumptionHistoryId;
    @ManyToOne
    @MapsId("coupon_code")
    @JoinColumns({
            @JoinColumn(name="coupon_code", referencedColumnName="code")
    })
    public Coupon coupon;
    private Date consumptionDate;
    public ConsumptionHistory(){
    }

    public ConsumptionHistory(String couponCode, long orderId, Date consumptionDate) {
        System.out.println("args");
        this.consumptionHistoryId = new ConsumptionHistoryId(couponCode,orderId);
        this.consumptionDate = consumptionDate;
    }
    public ConsumptionHistoryId getConsumptionHistoryId() {
        return consumptionHistoryId;
    }

    public void setConsumptionHistoryId(ConsumptionHistoryId consumptionHistoryId) {
        this.consumptionHistoryId = consumptionHistoryId;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }
}
