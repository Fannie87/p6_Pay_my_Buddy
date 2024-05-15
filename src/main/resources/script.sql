drop database pay_my_buddy;
create database pay_my_buddy;
use pay_my_buddy;

DROP TABLE IF EXISTS connections;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS dbuser;
DROP TABLE IF EXISTS transaction;

CREATE TABLE dbuser (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT null,
  first_name VARCHAR(250) NOT null,
  last_name VARCHAR(250) NOT null,
  balance FLOAT default 0.0,
  CONSTRAINT UC_User UNIQUE (mail)
 );

CREATE TABLE account (
  id_account INT auto_increment PRIMARY KEY,
  id_user INT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES dbuser(id),
  iban VARCHAR(250) NOT NULL,
  bic VARCHAR(250) NOT NULL,
  name_account VARCHAR(250)
  );
 
 CREATE TABLE connections (
  id_user INT,
  id_friend INT,
  FOREIGN KEY (id_user) REFERENCES dbuser(id),
  FOREIGN KEY (id_friend) REFERENCES dbuser(id),
  PRIMARY KEY(id_user, id_friend)
  );
 
 create table transaction(
	id_trade INT auto_increment primary KEY,
	id_user INT,
	id_friend INT,
	description VARCHAR(250),
	amount FLOAT not NULL,
	FOREIGN KEY (id_user) REFERENCES dbuser(id)
	);


INSERT INTO dbuser (mail, password, first_name , last_name) VALUES 
('user@gmail.com', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i' 	, "user"  	, "0" ),
('admin@gmail.com', '$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC' 	, "admin"  	, "0" ),
('user1@gmail.com', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i'	, "user"  	, "1" ),
('user2@gmail.com', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i'	, "user"  	, "2" ),
('user3@gmail.com', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i' 	, "user"  	, "3" );
INSERT INTO account (id_user, iban, bic, name_account) VALUES (1,'FRXXX','AGRI' , 'compte user');
INSERT INTO connections (id_user, id_friend) VALUES (1,2), (1,3), (1,4);
INSERT INTO transaction (id_user, id_friend, description, amount) VALUES 
(1,2, 'Money send', 10.00),
(1,2, 'Money send', 15.00),
(1,3, 'Money send', 8.00);

