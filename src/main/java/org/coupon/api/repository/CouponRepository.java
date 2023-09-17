package org.coupon.api.repository;
import org.coupon.api.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CouponRepository extends JpaRepository<Coupon, String> {
}
