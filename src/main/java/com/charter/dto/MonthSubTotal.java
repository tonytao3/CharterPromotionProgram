package com.charter.dto;

import java.time.Month;

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
public class MonthSubTotal{
	private int monthTotal;
	private int year;
	private Month month;
}