package com.charter.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Setter
@Getter
public class PointsMonthSubTotalDto {
	private String userId;
	private List<MonthSubTotal> monthSubTotals;
	private int total;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Setter
@Getter
class MonthSubTotal{
	private int monthTotal;
	private LocalDate date;	
}