

CREATE SEQUENCE client_id_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE Clients (id NUMBER NOT NULL PRIMARY KEY,
		              name VARCHAR (100) NOT NULL,
		              surname VARCHAR (100) NOT NULL,
		              birthday DATE NOT NULL,
		              height DECIMAL (10) NOT NULL);