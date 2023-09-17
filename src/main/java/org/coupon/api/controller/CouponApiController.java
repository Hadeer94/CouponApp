package org.coupon.api.controller;

import org.coupon.api.model.ConsumptionHistory;
import org.coupon.api.model.Coupon;
import org.coupon.api.repository.ConsumptionHistoryRepo;
import org.coupon.api.repository.CouponRepository;
import org.coupon.api.service.ConsumptionHistoryService;
import org.coupon.api.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value="/coupons")
public class CouponApiController {
    @Autowired
    private CouponService couponService;
    @Autowired
    private ConsumptionHistoryService consumptionHistoryService;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private ConsumptionHistoryRepo consumptionHistoryRepo;
    @PostMapping(path="/add")
    public ResponseEntity<Coupon> addNewCoupon(@RequestBody Coupon coupon) {
        Coupon newCoupon = couponService.save(coupon);
        return new ResponseEntity(newCoupon, HttpStatus.CREATED);
    }
    @GetMapping(path="/allCoupons")
    public ResponseEntity<List<Coupon>> getAllCoupons(){
        List<Coupon> result= couponRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping(path ="/consume")
    public String consumeCoupon(@RequestBody ConsumptionHistory consumptionHistory) {
        Coupon coupon = couponRepository.findById(consumptionHistory.getConsumptionHistoryId().getCoupon_code()).get();
        consumptionHistory.setCoupon(coupon);
        return consumptionHistoryService.save(consumptionHistory);
    }
    @GetMapping(path="/history")
    public List<ConsumptionHistory> getConsumptionHistory(){
        return consumptionHistoryRepo.findAll();
    }
}
