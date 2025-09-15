CREATE TABLE students (
    name  VARCHAR2(50),
    marks NUMBER(5)
);

INSERT INTO students (name, marks) VALUES ('Mohamed Salah', 95);
INSERT INTO students (name, marks) VALUES ('Ahmed Ali', 88);
INSERT INTO students (name, marks) VALUES ('Sara Hassan', 76);
INSERT INTO students (name, marks) VALUES ('John Doe', 65);
INSERT INTO students (name, marks) VALUES ('Fatma Adel', 82);

SELECT * FROM STUDENTS;



SELECT  NAME , MARKS,
CASE 
		WHEN MARKS >= 90  THEN  'A'
		WHEN MARKS  >= 80 THEN  'B' 
		WHEN MARKS >= 70  THEN  'C'

              ELSE 'F'  END  "GRADES"
      FROM students;
