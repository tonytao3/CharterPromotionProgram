package com.charter.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {

	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "customer_id")
  private String customerId;

  @Column(name = "transaction_type")
  private String transactionType;

  @Column(name = "transaction_time")
  private LocalDateTime transationTime;
  
  @Column(name = "paid_amount")
  private int paidAmount;
  
  @Column(name = "points")
  private int points;

}


