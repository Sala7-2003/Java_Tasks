CREATE TABLE Doctors(Id , Name , Salary ) AS SELECT Employee_id , first_name || last_name ,salary FROM employees;
-- we will fill the data from table employees which is provided by default from dbeaver 

SELECT *FROM Doctors;

DELETE  FROM Doctors 
WHERE id >= 110;


UPDATE Doctors
SET id = MOD(id,10);-- the ids were FROM 100 TO 109

UPDATE Doctors SET id = id + 1; -- so that the range is between 1 to 10 not 0 to 9

ALTER TABLE Doctors ADD ADDRESS varchar2(50);

UPDATE Doctors
SET address = 'Cairo , Egypt' ;

UPDATE Doctors 
SET salary = 20000 
WHERE id = 3 ;

DELETE FROM doctors WHERE id = 9 ;

SELECT name || ' ' ||salary AS "name and salary" FROM doctors;

SELECT id, name, salary, salary * 2 AS double_salary , address
FROM doctors;

SELECT *
FROM doctors
WHERE salary IN (9000, 4800, 6000);

ALTER TABLE Doctor RENAME TO PRD_DOCTOR;



