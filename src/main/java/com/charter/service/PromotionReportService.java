package com.charter.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charter.dto.MonthSubTotal;
import com.charter.dto.PointsMonthSubTotalDto;
import com.charter.dto.PointsReportDto;
import com.charter.model.Transaction;
import com.charter.reporsitory.TransactionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PromotionReportService {
	 
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	TransactionRepository transactionRepository;
     
    public ResponseEntity<List<PointsMonthSubTotalDto>> getPointsReport(){
		
		LocalDateTime fromDateTime = LocalDateTime.of(LocalDate.of(2023, 05, 01), LocalTime.of(00, 00));
		LocalDateTime endDateTime = LocalDateTime.of(LocalDate.of(2023, 07, 31), LocalTime.of(23, 59));
		logger.info("PromotionReportService::getPointsReport start from: " + fromDateTime);
	    logger.info("PromotionReportService::getPointsReport start end at: " + endDateTime);
		List<Transaction> transactionList = transactionRepository.findAllPointsReportData(fromDateTime, endDateTime);
		
		Map<String, List<Transaction>> groupedTransactionsMap = transactionList.stream().map(a -> { 
			if (a.getPaidAmount() > 50 && a.getPaidAmount() <= 100) {
				a.setPoints((a.getPaidAmount() - 50)*1);
			} else if (a.getPaidAmount() > 100 ) {
				a.setPoints((a.getPaidAmount() - 100)*2);
			} 
			return a; }).collect(Collectors.groupingBy(Transaction::getCustomerId));
		
		logger.info("groupedTransactionsMap: " + groupedTransactionsMap);
		
		List<PointsMonthSubTotalDto> dtoList = new ArrayList<>();
		PointsMonthSubTotalDto pointsMonthSubTotalDto;
		List<MonthSubTotal> subTotalList;
		MonthSubTotal monthSubTotal;
		for (Map.Entry<String, List<Transaction>> theEntry : groupedTransactionsMap.entrySet()) {
			pointsMonthSubTotalDto = new PointsMonthSubTotalDto();
			subTotalList = new ArrayList<>();
			pointsMonthSubTotalDto.setUserId(theEntry.getKey());
			Integer  sumValue = 0;
			Map<Object, List<Transaction>> monthSubMap = theEntry.getValue().stream().collect(Collectors.groupingBy( 
					a-> { return ((Transaction) a).getTransationTime().getMonth();}
					)); 
			for (Map.Entry<Object, List<Transaction>> subEntry : monthSubMap.entrySet()) {
				monthSubTotal = new MonthSubTotal();
				monthSubTotal.setYear((int) subEntry.getValue().get(0).getTransationTime().getYear());
				monthSubTotal.setMonth((Month) subEntry.getKey());
				monthSubTotal.setMonthTotal(subEntry.getValue().stream().mapToInt(a -> {  return (int) a.getPaidAmount();}).sum());
				sumValue += monthSubTotal.getMonthTotal();
				subTotalList.add(monthSubTotal);
			}
			pointsMonthSubTotalDto.setMonthSubTotals(subTotalList);
			pointsMonthSubTotalDto.setTotal(sumValue);
			
			dtoList.add(pointsMonthSubTotalDto);
		}
		  
		return new ResponseEntity<List<PointsMonthSubTotalDto>> (dtoList, HttpStatus.OK);
    }
}
