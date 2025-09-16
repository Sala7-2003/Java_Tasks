SELECT * FROM employees ;

-- ==================  1 AVG - 2 COUNT -3 MAX - 4 MIN - 5 SUM Function ==============
SELECT TO_CHAR(AVG(SALARY), '9,999.99') AS "AVERAGE EMPLOYYES SALARY" FROM EMPLOYEES;

SELECT COUNT(*) AS "NUMBER OF EMPLOYYES" FROM EMPLOYEES;

SELECT MAX(SALARY) FROM EMPLOYEES e ;

SELECT MIN(SALARY) FROM EMPLOYEES e ;

SELECT SUM(SALARY) FROM EMPLOYEES e ;

-- ================= 6 ======================
-- THIS NVL IS TO REMOVE THE NULL AND PUT 1 INSTEAD
SELECT NVL(E.DEPARTMENT_ID,1) , AVG(SALARY) FROM EMPLOYEES E  GROUP BY NVL(DEPARTMENT_ID,1);


-- ================ 7 ==========================
SELECT E.JOB_ID , COUNT(*) FROM EMPLOYEES E  GROUP BY E.JOB_ID;

-- =============== 9 ===========================
SELECT  AVG(e.COMMISSION_PCT ) FROM EMPLOYEES E WHERE e.COMMISSION_PCT IS NOT null;

-- =============== 10 ==========================
SELECT COUNT(*) AS high_salary_employees
FROM employees
WHERE salary > 10000;

-- ============== 11 ===========================
SELECT MAX(E.SALARY) , MIN(E.SALARY ) , JOB_ID FROM EMPLOYEES e GROUP BY E.JOB_ID ;

-- ============== 12 ===========================
SELECT SUM(E.SALARY) , E.MANAGER_ID  FROM EMPLOYEES e GROUP BY E.MANAGER_ID  ;


-- ============== 13 ==========================
SELECT department_id, JOB_ID , COUNT(*) , SUM(SALARY)
FROM employees
GROUP BY department_id , JOB_ID ;


-- ============= 15 ===========================
SELECT department_id, 
       COUNT(*)       AS Total_Employees, 
       AVG(salary)    AS Average_Salary, 
       MAX(salary)    AS Maximum_Salary, 
       MIN(salary)    AS Minimum_Salary
FROM employees
GROUP BY department_id;

-- ============== 17 ==========================
SELECT SUM (SALARY) AS S  ,  E.DEPARTMENT_ID  FROM EMPLOYEES E GROUP BY E.DEPARTMENT_ID  ORDER BY S DESC FETCH NEXT 1 ROWS ONLY ;

-- ============== 18 ===========================
SELECT department_id, SUM(salary) AS Total_Salary, TO_CHAR(AVG(SALARY), '$9,999,999.99') AS Average_Salary FROM employees
GROUP BY department_id;
