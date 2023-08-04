package com.charter.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charter.reporsitory.TransactionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PromotionReportService {
	 
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	TransactionRepository transactionRepository;
     
	public ResponseEntity<List<Object>> getPointsReport(){
		
		LocalDateTime fromDateTime = LocalDateTime.of(LocalDate.of(2023, 05, 01), LocalTime.of(00, 00));
		LocalDateTime endDateTime = LocalDateTime.of(LocalDate.of(2023, 07, 31), LocalTime.of(23, 59));
		logger.info("PromotionReportService::getPointsReport start from: " + fromDateTime);
	    logger.debug("PromotionReportService::getPointsReport start end at: " + endDateTime);
		List<Object> transactionList = transactionRepository.findPointsReportData(fromDateTime, endDateTime);
		 
		return new ResponseEntity<List<Object>> (transactionList, HttpStatus.OK);
    }
}
