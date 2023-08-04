package com.charter.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.charter.model.Transaction;
import com.charter.service.PromotionReportService;

import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class ProgramControllerTest {
	@Mock
    PromotionReportService promotionReportService;

    @Mock
    HttpServletRequest request;

    @InjectMocks
    ProgramController programController = new ProgramController(promotionReportService);

    @Test
    public void testGetTransactions() {
    	ResponseEntity<List<Object>> resp = programController.getDollorPointsReport();
    }
}
