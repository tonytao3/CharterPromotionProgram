package com.charter.reporsitory;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.charter.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query(value = "select a.customer_id as userId, round(sum(a.paid_amount)/3) as pointsMonthAverage, sum(a.paid_amount) as total \r\n"
			+ "from transaction a \r\n"
			+ "where a.transaction_time > ?1 and a.transaction_time < ?2 \r\n"
			+ "GROUP BY customer_id",
			nativeQuery = true)
	List<Object> findPointsReportData(LocalDateTime startDate, LocalDateTime endDate);
}
