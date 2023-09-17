package org.coupon.api.repository;

import org.coupon.api.model.ConsumptionHistory;
import org.coupon.api.model.ConsumptionHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionHistoryRepo extends JpaRepository<ConsumptionHistory, ConsumptionHistoryId> {
}