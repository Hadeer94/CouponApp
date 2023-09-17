package org.coupon.api.service;

import org.coupon.api.repository.ConsumptionHistoryRepo;
import org.coupon.api.repository.CouponRepository;
import org.coupon.api.model.ConsumptionHistory;
import org.coupon.api.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ConsumptionHistoryService {
    @Autowired
    private ConsumptionHistoryRepo consumptionHistoryRepo;
    @Autowired
    private CouponRepository couponRepository;
    String couponConsumingStatus ="coupon valid and consumed";
    public String save(ConsumptionHistory consumptionHistory) {
        Coupon coupon = consumptionHistory.getCoupon();
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
       // Date consumptionDate = sdf.parse(consumptionHistory.getConsumptionDate().toString());
        if(isCouponValid(coupon,consumptionHistory.getConsumptionDate())){
            consumptionHistoryRepo.save(consumptionHistory);
            coupon.incrementUsage();
            couponRepository.save(coupon);
        }
        return couponConsumingStatus;
    }

    public boolean isCouponValid(Coupon coupon, Date consumptionDate){
        if(coupon.getStatus().equals("invalid")){
            couponConsumingStatus=  "can't apply coupon : coupon is invalid";
            return false;
        }
        else if(coupon.getCurrentNoOfUsage()>=coupon.getMaxNoOfUsage()){
            couponConsumingStatus = "can't apply coupon :coupon reached max no of usage";
            return  false;
        }
//        else if(consumptionDate.after(coupon.getExpiryDate())){
//            couponConsumingStatus= "can't apply coupon :coupon expired";
//            return false;
//        }
        return true;
    }
}
