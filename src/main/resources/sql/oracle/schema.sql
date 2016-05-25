DROP TABLE NKCS_SCHEDULE PURGE;
DROP TABLE NKCS_ORDER_ITEM PURGE;
DROP TABLE NKCS_LOCATION PURGE;
DROP TABLE NKCS_RESERVATION PURGE;
DROP TABLE NKCS_MENU_SALE PURGE;
DROP TABLE NKCS_PERSONNEL PURGE;
DROP TABLE NKCS_ORDER PURGE;
DROP TABLE NKCS_TABLE PURGE;
DROP TABLE NKCS_MENU PURGE;
DROP TABLE NKCS_CATEGORY PURGE;
DROP TABLE NKCS_ACCOUNT_ITEM PURGE;
DROP TABLE NKCS_WAREHOUSE_LOG PURGE;
DROP TABLE NKCS_WAREHOUSE PURGE;
DROP TABLE NKCS_MESSAGE PURGE;

CREATE TABLE NKCS_PERSONNEL (
	personnel_id		INTEGER,
	personnel_name	VARCHAR2(30) NOT NULL,
	personnel_job		VARCHAR2(30) NOT NULL,
	salary		      NUMBER(7,2) NOT NULL,
	status		      VARCHAR2(1000),           --记录打卡信息
	CONSTRAINT pk_personnel PRIMARY KEY(personnel_id),
  CONSTRAINT ck_personnel_salary 	check(salary>0)
);

CREATE TABLE NKCS_TABLE(
	table_id		  INTEGER,
	status		    VARCHAR2(10),       --free,reserved,dirty,occupied
	people_number	INTEGER NOT NULL,
	CONSTRAINT pk_table PRIMARY KEY(table_id),
  CONSTRAINT ck_table_peoplenumber check(people_number between 1 and 20),
  CONSTRAINT ck_table_status check (status in ('free','reserved','dirty','occupied'))
);

CREATE TABLE NKCS_LOCATION(
  location_id   INTEGER NOT NULL,
	table_id	    INTEGER ,
	floor		      INTEGER NOT NULL,
	x		          NUMBER(7,2) NOT NULL,
	y		          NUMBER(7,2) NOT NULL,
	CONSTRAINT pk_location PRIMARY KEY(location_id),
	CONSTRAINT fk_location_id FOREIGN KEY(table_id) REFERENCES NKCS_TABLE(table_id),
  CONSTRAINT ck_location_floor check(floor>0),
  CONSTRAINT ck_location_x  check(x>0),
  CONSTRAINT ck_location_y  check(y>0)
);


CREATE TABLE NKCS_RESERVATION(
  reservation_id      INTEGER NOT NULL,
	table_id      		  INTEGER,
	people_number	      INTEGER NOT NULL,
  customer_name       VARCHAR2(30) NOT NULL,
  customer_telephone  VARCHAR2(11) NOT NULL,
	starttime	          DATE NOT NULL,
	endtime		          DATE NOT NULL,
	CONSTRAINT pk_reservation PRIMARY KEY(table_id,starttime),
	CONSTRAINT fk_reservation_id FOREIGN KEY(table_id) REFERENCES NKCS_TABLE(table_id),
	CONSTRAINT ck_reservation_time 	check(starttime<endtime),
  CONSTRAINT ck_reservation_peoplenumber check(people_number between 1 and 20)
);

CREATE TABLE NKCS_CATEGORY(
  category_id      INTEGER,
  category_name    VARCHAR(30) NOT NULL,
  CONSTRAINT pk_category PRIMARY KEY(category_id),
  CONSTRAINT u_category_name unique(category_name)
);

CREATE TABLE NKCS_MENU(
	dish_id		  INTEGER,
	dish_name		VARCHAR2(30) NOT NULL,
	category_id	INTEGER NOT NULL,
	price		    NUMBER(7,2) NOT NULL,
  updatetime	DATE NOT NULL,
  image       VARCHAR2(50),
  description VARCHAR2(300),
	CONSTRAINT pk_menu PRIMARY KEY(dish_id),
  CONSTRAINT ck_menu_price check(price>0),
  CONSTRAINT fk_menu_categoryid FOREIGN KEY(category_id) REFERENCES NKCS_CATEGORY(category_id)
);

CREATE TABLE NKCS_ORDER(
  	order_id        INTEGER,
  	paid_date       DATE,
  	payment         NUMBER(7,2),
  	status          VARCHAR2(10),        --ordering,waiting,completed,paid
  	wait_starttime  DATE,
  	wait_endtime    DATE,
  	table_id        INTEGER NOT NULL,
  	CONSTRAINT pk_order PRIMARY KEY(order_id),
  	CONSTRAINT fk_order_tableid FOREIGN KEY(table_id) REFERENCES NKCS_TABLE(table_id),
  	CONSTRAINT ck_order_status check (status in ('ordering','waiting','completed','paid'))
);

CREATE TABLE NKCS_MENU_SALE(
  	dish_id              INTEGER NOT NULL,
  	sale_date       DATE NOT NULL,	
  	sale_quantity    INTEGER,
  	CONSTRAINT pk_menu_sale PRIMARY KEY(dish_id,sale_date),
  	CONSTRAINT fk_menu_sale_id FOREIGN KEY(dish_id) REFERENCES NKCS_MENU(dish_id),
  	CONSTRAINT ck_menu_sale_quantity check(sale_quantity>0)
);

CREATE TABLE NKCS_ACCOUNT_ITEM(
  	item_id       INTEGER,
  	record_date   DATE NOT NULL,
  	profit        NUMBER(7,2),
  	loss          NUMBER(7,2),
  	CONSTRAINT pk_account_item PRIMARY KEY(item_id),
  	CONSTRAINT ck_account_item_profit check(profit>0),
  	CONSTRAINT ck_account_item_loss   check(loss>0)
);

CREATE TABLE NKCS_WAREHOUSE_LOG(
  	log_id      INTEGER,
  	log_name    VARCHAR2(30) NOT NULL,
  	quantity    INTEGER NOT NULL,
  	record_date DATE,
  	unit_price  NUMBER(7,2),
  	CONSTRAINT pk_warehouse_log PRIMARY KEY(log_id),
  	CONSTRAINT ck_warehouse_log_quantity check(quantity<>0),
  	CONSTRAINT ck_warehouse_log_unitprice check(unit_price>0)
);

CREATE TABLE NKCS_WAREHOUSE(
  	warehouse_item_id        INTEGER,
  	warehouse_item_name      VARCHAR2(30) NOT NULL,
  	quantity                 INTEGER NOT NULL,
  	CONSTRAINT pk_warehouse PRIMARY KEY(warehouse_item_id)
);

CREATE TABLE NKCS_MESSAGE(
  	message_id                    INTEGER,
  	message_date          DATE NOT NULL,
  	message_type          VARCHAR2(50) NOT NULL,
  	description           VARCHAR2(150) NOT NULL,
  	CONSTRAINT pk_message PRIMARY KEY(message_id),
  	CONSTRAINT ck_message_type check (message_type in ('ingredients shortage','change shifts','customer complaints','employee advise'))
);

--关系集schedule
CREATE TABLE NKCS_SCHEDULE(
  	waiter_id   INTEGER ,
  	table_id    INTEGER ,
  	work_date   DATE NOT NULL,
  	period      VARCHAR2(50) NOT NULL,
  	CONSTRAINT pk_schedule PRIMARY KEY(waiter_id, table_id, work_date),
  	CONSTRAINT fk_schedule_waiterid FOREIGN KEY(waiter_id) REFERENCES NKCS_PERSONNEL(personnel_id),
  	CONSTRAINT fk_schedule_tableid FOREIGN KEY(table_id) REFERENCES NKCS_TABLE(table_id),
  	CONSTRAINT ck_schedule_period check (period in ('morning','afternoon','night','morning_afternoon','morning_night','afternoon_night','all_day'))
);

--关系集order_item
CREATE TABLE NKCS_ORDER_ITEM(
  	order_id      INTEGER NOT NULL,
  	dish_id       INTEGER NOT NULL,
  	quantity      INTEGER NOT NULL,
  	status        VARCHAR2(10),    --ordering,preparing,cooking,finished
  	each_payment  NUMBER(7,2),
  	CONSTRAINT pk_orderitem_order_dish PRIMARY KEY(order_id,dish_id),
  	CONSTRAINT fk_orderitem_orderid FOREIGN KEY(order_id) REFERENCES NKCS_ORDER(order_id),
  	CONSTRAINT fk_orderitem_dishid FOREIGN KEY(dish_id) REFERENCES NKCS_MENU(dish_id),
  	CONSTRAINT ck_orderitem_quantity check(quantity>0),
  	CONSTRAINT ck_orderitem_status check (status in ('ordering','preparing','cooking','finished'))
);

commit;
--1.自增长序列NKCS_PERSONNEL
CREATE SEQUENCE NKCS_PERSONNEL_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1
NOCACHE; 

--2.自增长序列NKCS_TABLE
CREATE SEQUENCE NKCS_TABLE_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--3.自增长序列NKCS_CATEGORY
CREATE SEQUENCE NKCS_CATEGORY_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--4.自增长序列NKCS_MENU
CREATE SEQUENCE NKCS_MENU_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--5.自增长序列NKCS_ORDER
CREATE SEQUENCE NKCS_ORDER_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--6.自增长序列WAREHOUSE_LOG
CREATE SEQUENCE NKCS_WAREHOUSE_LOG_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--7.自增长序列NKCS_MESSAGE
CREATE SEQUENCE NKCS_MESSAGE_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--8.自增长序列NKCS_LOCATION
CREATE SEQUENCE NKCS_LOCATION_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--9.自增长序列NKCS_RESERVATION
CREATE SEQUENCE NKCS_RESERVATION_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--10.自增长序列NKCS_ACCOUNT_ITEM
CREATE SEQUENCE NKCS_ACCOUNT_ITEM_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE; 

--11 自增长序列NKCS_WAREHOUSE
CREATE SEQUENCE NKCS_WAREHOUSE_ID_SEQ 
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 
NOCACHE;

--对personnel表进行修改，完成登录功能
alter table nkcs_personnel add login_name varchar2(64) not null unique;
alter table nkcs_personnel add password varchar2(255) not null;
alter table nkcs_personnel add salt varchar2(64) not null;
