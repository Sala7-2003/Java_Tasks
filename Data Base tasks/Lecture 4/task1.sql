CREATE TABLE EMP_TEST (
NAME VARCHAR2(30),
ID NUMBER (9) , 
EMAIL VARCHAR2(50)
);

SET  SERVEROUTPUT ON;

CREATE SEQUENCE emp_seq MINVALUE 1 START WITH 1
  INCREMENT BY 1  NOCACHE ; 



SELECT * FROM EMP_TEST;

INSERT INTO  EMP_TEST VALUES ('    MOHAMED SALAH  ' ,  emp_seq.nextval , '  **nedo@lknc### ');
INSERT INTO emp_test VALUES ('         AHMED  ALI', emp_seq.NEXTVAL, '*ahmed##@mail.com   ');
INSERT INTO emp_test VALUES ('   SARA   HASSAN ', emp_seq.NEXTVAL, '   sara***@xyz#mail.com');
INSERT INTO emp_test VALUES ('   JOHN   DOE   ', emp_seq.NEXTVAL, '   ###john@doe***   ');
INSERT INTO emp_test VALUES (' ***LAILA   ', emp_seq.NEXTVAL, ' laila@##abc*com   ');
INSERT INTO emp_test VALUES ('   KARIM##  ', emp_seq.NEXTVAL, '  karim**@####testmail.com ');
INSERT INTO emp_test VALUES ('   FATMA *   * ', emp_seq.NEXTVAL, '**fatma@###demo.com   ');
INSERT INTO emp_test VALUES ('   OMAR   ', emp_seq.NEXTVAL, '   omar###@mail**com ');
INSERT INTO emp_test VALUES ('  HANA  ', emp_seq.NEXTVAL, '  ##hana***@mail.com  ');
INSERT INTO emp_test VALUES ('   YOUSSEF  *   ', emp_seq.NEXTVAL, ' y##oussef***@mail.com  ');


SELECT TRIM ( BOTH ' ' FROM NAME ) TEXT FROM EMP_TEST  ;

SELECT LTRIM (NAME , ' ') TEXT FROM EMP_TEST et ;

SELECT RTRIM (NAME , ' *#') TEXT FROM EMP_TEST et ;

SELECT LTRIM ( RTRIM(NAME , ' *#') , ' *#' ) TEXT FROM EMP_TEST ;





