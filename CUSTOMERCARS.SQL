Create DATABASE CUSTOMERCARS;
use CUSTOMERCARS;

CREATE TABLE IF NOT EXISTS Orders (
	OrderID int NOT NULL AUTO_INCREMENT,
	Date DATE Not Null,
	CustId int Not Null,
	CarID int NOT Null,
	PRIMARY KEY (OrderID)
);

INSERT INTO Orders (Date, CustId, CarID)
VALUES	(CURDATE(), 1,1),
		(CURDATE(),2,2),
		(CURDATE(),3,3);
		
SELECT * from Orders;

