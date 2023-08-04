package com.charter.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charter.dto.PointsMonthSubTotalDto;
import com.charter.dto.PointsReportDto;
import com.charter.model.Transaction;
import com.charter.reporsitory.TransactionRepository;

import lombok.AllArgsConstructor;
import oracle.net.aso.s;

@AllArgsConstructor
@Service
public class PromotionReportService {
	 
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	TransactionRepository transactionRepository;
    
	public ResponseEntity<List<PointsReportDto>> getMaonthAveragePoints(){
		
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
		List<PointsReportDto> dtoList = new ArrayList<>();
		PointsReportDto pointsReportDto;
		for (Map.Entry<String, List<Transaction>> theEntry : groupedTransactionsMap.entrySet()) {
			pointsReportDto = new PointsReportDto();
			pointsReportDto.setUserId(theEntry.getKey());
			int sumValue = 0;
			for (int i = 0; i < theEntry.getValue().size(); i ++) {
				sumValue += theEntry.getValue().get(i).getPoints();
			}
			pointsReportDto.setPointsMonthAverage(sumValue/3);
			pointsReportDto.setTotal(sumValue);
			dtoList.add(pointsReportDto);
		}
		  
		return new ResponseEntity<List<PointsReportDto>> (dtoList, HttpStatus.OK);
    }
	
	public ResponseEntity<List<Object>> getDollarPointsReport(){
		
		LocalDateTime fromDateTime = LocalDateTime.of(LocalDate.of(2023, 05, 01), LocalTime.of(00, 00));
		LocalDateTime endDateTime = LocalDateTime.of(LocalDate.of(2023, 07, 31), LocalTime.of(23, 59));
		logger.info("PromotionReportService::getPointsReport start from: " + fromDateTime);
	    logger.info("PromotionReportService::getPointsReport start end at: " + endDateTime);
		List<Object> transactionList = transactionRepository.findPointsReportData(fromDateTime, endDateTime);
		
		 
		return new ResponseEntity<List<Object>> (transactionList, HttpStatus.OK);
    }	
}
