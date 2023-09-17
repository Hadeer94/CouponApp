package org.coupon.api.service;

import org.coupon.api.repository.CouponRepository;
import org.coupon.api.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public Coupon save(Coupon coupon){
        return couponRepository.save(coupon);
    }

}
