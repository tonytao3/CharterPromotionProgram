#For H2
Drop Table transaction;
CREATE TABLE transaction(
   id IDENTITY NOT NULL PRIMARY KEY,
   customer_id VARCHAR(10),
   transaction_type VARCHAR(10),
   transaction_time timestamp,
   paid_amount INT,
);
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1001, 'ntao', 125, 'Sale', TO_TIMESTAMP('2023-06-22 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1002, 'ntao', 50, 'Sale', TO_TIMESTAMP('2023-06-28 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1003, 'ntao', 180, 'Sale', TO_TIMESTAMP('2023-07-25 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1004, 'ntao', 200, 'Sale', TO_TIMESTAMP('2023-05-23 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1005, 'ntao', 500, 'Sale', TO_TIMESTAMP('2023-06-11 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1006, 'shuying', 150, 'Sale', TO_TIMESTAMP('2023-06-24 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1007, 'shuying', 250, 'Sale', TO_TIMESTAMP('2023-05-20 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1008, 'shuying', 400, 'Sale', TO_TIMESTAMP('2023-07-12 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1009, 'shuying', 200, 'Sale', TO_TIMESTAMP('2023-07-22 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1010, 'lee', 130, 'Sale', TO_TIMESTAMP('2023-05-22 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1011, 'lee', 120, 'Sale', TO_TIMESTAMP('2023-07-25 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1012, 'lee', 160, 'Sale', TO_TIMESTAMP('2023-06-10 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO transaction (id, customer_id, paid_amount, transaction_type, transaction_time) VALUES (1013, 'lee', 300, 'Sale', TO_TIMESTAMP('2023-06-22 17:16:05', 'YYYY-MM-DD HH24:MI:SS'));
