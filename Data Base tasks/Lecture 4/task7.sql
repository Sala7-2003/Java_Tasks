-- =====================  1. Character Functions – Part 3 (TRIM, LTRIM, RTRIM)  ============================

CREATE TABLE CUSTOMERS (
FULL_NAME VARCHAR2(50)
);

INSERT INTO CUSTOMERS VALUES('       #MOHAMED**** ');
INSERT INTO CUSTOMERS VALUES('     ALI FADL**** ');
INSERT INTO CUSTOMERS VALUES('     KAREEM MOHAMED**** ');
INSERT INTO CUSTOMERS VALUES('            SARA AHMED**** ');
INSERT INTO CUSTOMERS VALUES('     FATMA ALAA      ');
INSERT INTO CUSTOMERS VALUES('     **** ASMAA MOHAMED####');
INSERT INTO CUSTOMERS VALUES('            KASEM HAMED ');
INSERT INTO CUSTOMERS VALUES('     MAHMOUD MOHAMED**    ###** ');
INSERT INTO CUSTOMERS VALUES('     AMIR SAYED**** ');
INSERT INTO CUSTOMERS VALUES('     AHMED MOHAMED   **** ');
INSERT INTO CUSTOMERS VALUES('     ALAA GOMAA**** ');
INSERT INTO CUSTOMERS VALUES('     JOHN MICHEL     ***      ');
INSERT INTO CUSTOMERS VALUES('     JOHN MICHEL         ');

SELECT FULL_NAME , TRIM( BOTH ' ' FROM FULL_NAME ) "NAME MODIFIED" FROM CUSTOMERS;


SELECT FULL_NAME , LTRIM( FULL_NAME , ' *#') FROM CUSTOMERS ;

SELECT FULL_NAME , RTRIM( FULL_NAME , ' *#') AS DATA FROM CUSTOMERS ;


-- =====================  2. Character Functions – Part 4 (REPLACE, LPAD, RPAD)   ============================
SELECT REPLACE ('PORMOTION' , 'O' , '0') FROM DUAL ;

SELECT REPLACE ('This is a basic course' , 'basic' , 'an ADVANCED') FROM DUAL ;


CREATE TABLE departments_1 (
    dept_name VARCHAR2(50)
);
SELECT * FROM DEPARTMENTS_1 d ;

INSERT INTO departments_1 (dept_name) VALUES ('Human Resources');
INSERT INTO departments_1 (dept_name) VALUES ('Finance');
INSERT INTO departments_1 (dept_name) VALUES ('Information Technology');

SELECT dept_name , LPAD ( dept_name , 22, '*' ) FROM DEPARTMENTS_1 d; 
SELECT dept_name , RPAD ( dept_name , 22, '-' ) FROM DEPARTMENTS_1 d; 


--  ======================= 3. TO_CHAR Function ======================
SELECT TO_CHAR(SYSDATE , 'DD-MON-YYYY') FROM DUAL;

SELECT TO_CHAR(SYSDATE , 'DAY-MONTH-YEAR') FROM DUAL;

SELECT TO_CHAR(12345.78,'99,999.90') SS FROM DUAL;

SELECT TO_CHAR(SALARY,'$99,999.90') SS FROM EMPLOYEES e ;

SELECT TO_CHAR(SYSDATE , 'DD-MON-YYYY HH24:MI:SS') CURRENT_DATE_TIME FROM DUAL;


-- ===================== 4. Oracle Conditional Expressions – CASE Expressions ==================
CREATE TABLE students (
    name  VARCHAR2(50),
    marks NUMBER(5)
);

INSERT INTO students (name, marks) VALUES ('Mohamed Salah', 95);
INSERT INTO students (name, marks) VALUES ('Ahmed Ali', 88);
INSERT INTO students (name, marks) VALUES ('Sara Hassan', 76);
INSERT INTO students (name, marks) VALUES ('John Doe', 65);
INSERT INTO students (name, marks) VALUES ('Fatma Adel', 82);
INSERT INTO students (name, marks) VALUES ('MALAK MAHMOUD', 59);

SELECT NAME , MARKS , CASE 
WHEN MARKS >= 90 THEN 'A'
WHEN MARKS >= 80 THEN 'B'
WHEN MARKS >= 70 THEN 'C'
ELSE 'F'
END "GRADE" 
FROM STUDENTS;
-- ===============
SELECT NAME , MARKS , CASE 
WHEN MARKS >= 60 THEN 'PASS'
ELSE 'FAIL'
END "STATUS" 
FROM STUDENTS;
-- ================
SELECT NAME , MARKS , CASE 
WHEN MARKS >= 90 THEN 'Excellent'
WHEN MARKS >= 80 THEN 'Good'
WHEN MARKS >= 70 THEN 'Average'
ELSE 'Needs Improvement'
END "GRADE" 
FROM STUDENTS;


--   Write a CASE expression using system date to return the name of the day (e.g., “Today is Monday”)
-- A simple way without case :
SELECT 'Today Is ' || TO_CHAR(SYSDATE , 'DAY') FROM DUAL ;

-- Another Solution using Case 
SELECT CASE TO_CHAR(SYSDATE , 'Dy')
         WHEN  'Mon' THEN 'Monday'
         WHEN 'Tue' THEN 'Tuesday'
         WHEN  'Sat' THEN 'Saturday'
         WHEN 'Sun' THEN 'Sunday'
         WHEN  'Wed' THEN 'Wednesday'
         WHEN 'Thu' THEN 'Thursday'
         ELSE 'Friday' 
     END as "DAY"
FROM DUAL ;


--====================== 5. Oracle Conditional Expressions – DECODE Function  =====================
SELECT * FROM STUDENTS s ;
SELECT DECODE (MARKS , 
95 , 'A',
65 , 'C' , 'F') FROM STUDENTS ;

CREATE TABLE STATUS_LOG (
STATUS_CODE VARCHAR2(30)
);


INSERT INTO STATUS_LOG VALUES ('N');
INSERT INTO STATUS_LOG VALUES ('I');
INSERT INTO STATUS_LOG VALUES ('I');
INSERT INTO STATUS_LOG VALUES ('I');
INSERT INTO STATUS_LOG VALUES ('C');
INSERT INTO STATUS_LOG VALUES ('C');
INSERT INTO STATUS_LOG VALUES ('N');
INSERT INTO STATUS_LOG VALUES ('N');

SELECT STATUS_CODE , DECODE(STATUS_CODE , 
'I' ,'IN Progress',
'N' , 'NEW',
'C' , 'COMPLETED')
FROM STATUS_LOG; 

-- ================== 
CREATE TABLE PRODUCTS(
P_NAME VARCHAR2(40),
QUANTITY NUMBER(5)
)

ALTER TABLE PRODUCTS ADD QUANTITY NUMBER(5); 


UPDATE PRODUCTS SET QUANTITY = 12 WHERE P_NAME = 'MILK' ;
UPDATE PRODUCTS SET QUANTITY = 2 WHERE P_NAME = 'SWEETS' ;
UPDATE PRODUCTS SET QUANTITY = 0 WHERE P_NAME = 'BREAD' ;

SELECT P_NAME , QUANTITY ,  CASE 
	WHEN QUANTITY > 0 THEN 'AVAILABLE'
	ELSE 'OUT OF STOCK'
END STATUS
FROM PRODUCTS p ;
-- =================
SELECT ID , JOB_ID , SALARY , CASE JOB_ID 
WHEN 'IT_PROG' THEN SALARY+1000
WHEN 'AD_VP' THEN SALARY+500
WHEN 'ST_CLERK' THEN SALARY + 2000
ELSE SALARY + 300 
END "SALARY WITH BONUS"
FROM EMPLOYEES e ;




