DROP TABLE IF EXISTS dbuser;

CREATE TABLE dbuser (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

INSERT INTO dbuser (mail, password) VALUES ('dbuser', '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.'),
('dbadmin', '$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC');