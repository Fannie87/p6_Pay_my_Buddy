DROP TABLE IF EXISTS connections;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS dbuser;


CREATE TABLE dbuser (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT null,
  firstName VARCHAR(250),
  lastName VARCHAR(250),
  balance INT,
  CONSTRAINT UC_User UNIQUE (mail)
 );

delete from dbuser;
INSERT INTO dbuser (mail, password) VALUES 
('user', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i'),
('admin', '$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC'),
('user1', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i'),
('user2', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i'),
('user3', '$2a$10$KpTU0U.XQznaqKR2C6AUVeN9YHL9FYKxJW/uIKYuGy3FGmdi6EI.i');

CREATE TABLE account (
  idAccount INT auto_increment PRIMARY KEY,
  idUser INT,
  FOREIGN KEY (idUser) REFERENCES dbuser(id),
  iban VARCHAR(250) NOT NULL,
  bic VARCHAR(250) NOT NULL,
  nameAccount VARCHAR(250)
  );

INSERT INTO account (idUser, iban, bic, nameAccount) VALUES (1,'FRXXX','AGRI' , 'compte user');

CREATE TABLE connections (
  idUser INT,
  idFriend INT,
  FOREIGN KEY (idUser) REFERENCES dbuser(id),
  FOREIGN KEY (idFriend) REFERENCES dbuser(id)
  );

INSERT INTO connections (idUser, idFriend) VALUES (1,2), (1,3), (1,4);


select * from connections;