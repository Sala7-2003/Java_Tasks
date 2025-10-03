Some notes to take into consideration :

1- I Used sessions and applied on it in the project but didn't use Cookies I wanted to make it if the user pressed remember me , but really the project took too much time for me and there other assignments to do !

2- I have built the whole project my self ! except for the front-end I used chat gpt , I didn't use the instructor code in order to have the experience of building a crud system using MVC on my own ( for me building a function or algo is easy but to get the view or architecture of project is hard so I made it own to practice on oop good practice and I really Learned too much )

3- The sign up is functional but it would get you to an error page however the account is saved in the DB and you can reuse it to sign in and it would work !

4- Put this code in dbeaver or sqldeveloper so that the db is activated :
CREATE TABLE items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price INT NUMBER(12),
    quantity NUMBER(6),
    detail VARCHAR(255),
    name VARCHAR(100) 
);

-- set auto increment starting point
ALTER TABLE items AUTO_INCREMENT = 2000;

CREATE TABLE USERS(
  id INT AUTO_INCREMENT PRIMARY KEY,
 username VARCHAR(255),
 password VARCHAR(100) 
);

ALTER TABLE users AUTO_INCREMENT = 1;

SELECT * FROM users i ;

================================

5- I didn't make filters on the data entered but for me it is easy but time consuming and there is too much to do yet !



6- There is line for caching in show-items.jsp page that prevents getting back to that page if you logged out

7- All the users can affect the same items db as I didn't use normalization ( it wasn't required ) 

8- i am doing my best to keep up with eslam and do all the tasks but he is rushing too fast in the content and most of it is new to me but trying to do my best .

Thanks for your time .