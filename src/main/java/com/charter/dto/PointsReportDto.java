package com.charter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Setter
@Getter
public class PointsReportDto {
	private String userId;
	private int pointsMonthAverage;
	private int total;
}
