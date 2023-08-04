package com.charter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Setter
@Getter
@Table(name = "transaction")
public class PointsReportDto {
	@Id
	@Column(name = "customer_id")
	private String userId;
	
	@Column(name = "points_month_average")
	private int pointsMonthAverage;
	
	@Column(name = "total")
	private int total;
}
