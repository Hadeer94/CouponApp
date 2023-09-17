package org.coupon.api.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Coupon {
    @Id
    private String code;
    @Column(name = "max_no_of_usage")
    private int maxNoOfUsage;
    @Column(name="current_no_of_usage")
    private int currentNoOfUsage;
    @Column(name="expiry_date")
    private Date expiryDate;
    private float value;
    @Column(name="value_type")
    private String valueType;
    @OneToMany(mappedBy="coupon")
    private List<ConsumptionHistory> consumptionHistoryList;
    private String status;
    public Coupon(){
        this.expiryDate=new Date();
    }

    public Coupon(String code, int maxNoOfUsage,  float value, String valueType, String status,Date expiryDate) {
        this.code = code;
        this.maxNoOfUsage = maxNoOfUsage;
        this.value = value;
        this.valueType = valueType;
        this.status = status;
        this.expiryDate = expiryDate;
        this.currentNoOfUsage=0;
        this.consumptionHistoryList = new ArrayList<>();

    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public int getMaxNoOfUsage() {
        return maxNoOfUsage;
    }
    public void setMaxNoOfUsage(int maxNoOfUsage) {
        this.maxNoOfUsage = maxNoOfUsage;
    }

    public int getCurrentNoOfUsage() {
        return currentNoOfUsage;
    }

    public void setCurrentNoOfUsage(int currentNoOfUsage) {
        this.currentNoOfUsage = currentNoOfUsage;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ConsumptionHistory> getConsumptionHistoryList() {
        return consumptionHistoryList;
    }

    public void setConsumptionHistoryList(List<ConsumptionHistory> consumptionHistoryList) {
        this.consumptionHistoryList = consumptionHistoryList;
    }

    public String getStatus() {
        return status;
    }
    public void incrementUsage(){
        currentNoOfUsage++;
    }

}
