DROP TABLE CUSTOMER CASCADE CONSTRAINTS;

CREATE TABLE CUSTOMER (
	CUSTOMER_ID NUMBER(10) ,
	EMAIL_ID VARCHAR2(20),
	NAME VARCHAR2(10),
	DATE_OF_BIRTH DATE,
	CONSTRAINT PS_CUSTOMER_ID_PK PRIMARY KEY ( CUSTOMER_ID )
);

INSERT INTO CUSTOMER (CUSTOMER_ID, EMAIL_ID, NAME, DATE_OF_BIRTH) VALUES (552092, 'martin@infy.com', 'Martin', SYSDATE-9136);

--commit;
select * from customer;