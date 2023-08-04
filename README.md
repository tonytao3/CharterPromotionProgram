# CharterPromotionProgram
Charter Promotion Program Demo

#Crat Datasource
Drop Table transaction;
CREATE TABLE transaction(
   id IDENTITY NOT NULL PRIMARY KEY,
   customer_id VARCHAR(10),
   transaction_type VARCHAR(10),
   transaction_time timestamp,
   paid_amount INT,
);
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('ntao', 125, 'Sale', ' '2023-5-20 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('ntao', 100, 'Sale', ' '2023-6-22 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('ntao', 300, 'Sale', ' '2023-7-12 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('ntao', 200, 'Sale', ' '2023-6-25 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('ntao', 400, 'Sale', ' '2023-6-28 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('shuying', 60, 'Sale', ' '2023-5-30 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('shuying', 100, 'Sale', ' '2023-6-25 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('shuying', 800, 'Sale', ' '2023-7-22 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('shuying', 400, 'Sale', ' '2023-6-11 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('lee', 900, 'Sale', ' '2023-7-25 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('lee', 500, 'Sale', ' '2023-6-21 23.59');
INSERT INTO transaction (customer_id, paid_amount, transaction_type, transaction_time) VALUES ('lee', 800, 'Sale', ' '2023-5-21 23.59');
