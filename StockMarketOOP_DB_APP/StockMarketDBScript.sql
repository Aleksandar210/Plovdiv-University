GO
CREATE DATABASE StockMarketDB

GO
USE StockMarketDB

--Creating table Products
GO
CREATE TABLE Products(
ID INT PRIMARY KEY IDENTITY NOT NULL,
ProductName NVARCHAR(50) NOT NULL,
ProductQuantity INT NOT NULL,
ProductPriceOnDelivery DECIMAL(19,2)  NOT NULL,
ProductPriceOnPurchase DECIMAL(19,2)  NOT NULL,
CONSTRAINT CHK_ProductPriceDelivery CHECK(ProductPriceOnDelivery>=0),
CONSTRAINT CHK_ProductPricePurcahse CHECK(ProductPriceOnPurchase>0),
CONSTRAINT CHK_ProductQuantity CHECK(ProductQuantity >0),
CONSTRAINT CHK_ProductName CHECK(LEN(ProductName)>3)
);

--Testing table insertion
GO
INSERT INTO Products(ProductName,ProductQuantity,ProductPriceOnDelivery,ProductPriceOnPurchase)
	VALUES
		('Banana',10,3,4),
		('Banana',10,2,4)
GO
SELECT * FROM Products

GO
TRUNCATE TABLE Products

--Creating table Countries in EU
CREATE TABLE Countries(
ID INT PRIMARY KEY IDENTITY NOT NULL,
CountryName NVARCHAR(50) NOT NULL
)
--Inserting countries in EU
INSERT INTO Countries(CountryName)
	VALUES
		('Austria'),
		('Belgium'),
		('Bulgaria'),
		('Croatia'),
		('Cyprus'),
		('Czechia'),
		('Denmark'),
		('Estonia'),
		('Finland'),
		('France'),
		('Germany'),
		('Greece'),
		('Hungary'),
		('Italy'),
		('Poland'),
		('Sweden'),
		('Portugal')

--Creating table Cities
CREATE TABLE Cities(
ID INT PRIMARY KEY IDENTITY NOT NULL,
CityName NVARCHAR(50) NOT NULL,
CountryID INT FOREIGN KEY REFERENCES Countries(ID) NOT NULL
)

SELECT * FROM Countries 

--Inserting 5 Cities from each country in database
INSERT INTO Cities(CityName,CountryID)
	VALUES
		('Vienna',1),
		('Bregenz',1),
		('Wolfsberg',1),
		('Traiskirchen',1),
		('Hall in Tirol',1),
		('Antwerp',2),
		('Brussels',2),
		('Harelbeke',2),
		('Lommel',2),
		('Dilsen-Stokkem',2),
		('Plovdiv',3),
		('Sofia',3),
		('Burgas',3),
		('Veliko Tarnovo',3),
		('Gabrovo',3),
		('Zagreb',4),
		('Rijeka ',4),
		('Dubrovnik ',4),
		('Sveti Ivan Zelina',4),
		('Slatina',4),
		('',5),
		('',5),
		('',5),
		('',5),
		('',5),
		('',6),
		('',6),
		('',6),
		('',6),
		('',6),
		('',7), 
		('',7), 
		('',7), 
		('',7), 
		('',7), 
		('',8), 
		('',8), 
		('',8), 
		('',8), 
		('',8),
		('',9),
		('',9),
		('',9),
		('',9),
		('',10),
		('',10),
		('',10),
		('',10),
		('',11),
		('',11),
		('',11),
		('',11),
		('',12),
		('',12),
		('',12),
		('',12),
		('',13),
		('',13),
		('',13),
		('',13),
		('',14),
		('',14),
		('',14),
		('',14),
		('',15),
		('',15),
		('',15),
		('',15),
		('',16),
		('',16),
		('',16),
		('',16),
		('',17),
		('',17),
		('',17),
		('',17),

		--TO DO FINISH THIS

--CREATING TABLE APPCREDENTIALS
CREATE TABLE AppCredentials(
ID INT PRIMARY KEY IDENTITY NOT NULL,
Username VARCHAR(40) NOT NULL,
EmailAddress VARCHAR(30) NOT NULL,
Password
)

--Creating table Users
CREATE TABLE Users(
ID INT PRIMARY KEY IDENTITY NOT NULL,
FirstName NVARCHAR(40) NOT NULL,
MiddleName NVARCHAR(40) NULL,
LastName NVARCHAR(40) NOT NULL,
Age SMALLINT NOT NULL,
WalletAmount DECIMAL(19,2) NOT NULL,
AppCredential INT FOREIGN KEY REFERENCES AppCredentials(ID) NOT NULL,
CityID INT FOREIGN KEY REFERENCES Cities(ID) NOT NULL,
CONSTRAINT CHK_UserAge CHECK(Age>18),
CONSTRAINT CHK_WalletAmount CHECK(WalletAmount>=0)
)