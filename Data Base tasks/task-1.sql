CREATE TABLE Manager (
id number(8) ,
name varchar2(50),
age number(2),
birthdate DATE ,
address varchar2(100)
) ;

ALTER TABLE Manager DROP (address);

ALTER TABLE Manager ADD (city_address varchar2(100) ,
street varchar2(50));

ALTER TABLE Manager RENAME COLUMN name TO full_name ;

ALTER TABLE Manager READ ONLY ;

CREATE TABLE Owner AS SELECT id , full_name , birthdate 
FROM Manager ;

RENAME  manager TO master ;