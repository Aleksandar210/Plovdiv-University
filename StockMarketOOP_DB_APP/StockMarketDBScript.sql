GO
CREATE DATABASE StockMarketDB

GO
USE StockMarketDB

GO
CREATE TABLE ProductTypes(
ID INT PRIMARY KEY IDENTITY NOT NULL,
ProductTypeName NVARCHAR(40) NOT NULL
);

INSERT INTO ProductTypes(ProductTypeName)
VALUES
	('Electronics'),
	('Food'),
	('Clothes'),
	('Vehicle'),
	('Cryptocurrency'),
	('Housing')

	
	

	SELECT * FROM ProductTypes

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

--mistakes were made bo we fix them.
ALTER TABLE Products 
DROP CONSTRAINT CHK_ProductQuantity

ALTER TABLE Products
DROP COLUMN ProductQuantity

ALTER TABLE Products
ADD ProductType INT FOREIGN KEY REFERENCES ProductTypes(ID) NOT NULL


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
		('Achna',5),
		('Buffavento',5),
		('Dhrousha',5),
		('Gerolakkos',5),
		('Idalium',5),
		('Praha ',6),
		('Opava',6),
		('Jihlava ',6),
		('Liberec ',6),
		('Brno ',6),
		('Kolding',7), 
		('Svendborg',7), 
		('Aabenraa',7), 
		('redensborg',7), 
		('Ringe',7), 
		('Tallinn',8), 
		('Keila',8), 
		('Lihula',8), 
		('Narva',8), 
		('Kallaste',8),
		('Porvoo',9),
		('Helsink',9),
		('Forssa',9),
		('Lapua',9),
		('Clermont',10),
		('Roubaix',10),
		('Dunkirk',10),
		('Pau',10),
		('Berlin',11),
		('Hamburg',11),
		('Frankfurt',11),
		('Shtutgard',11),
		('Athens',12),
		('Larissa',12),
		('Evosmos',12),
		('Kamatero',12),
		('Budapest',13),
		('Debrecen',13),
		('Szeged',13),
		('Miskolc',13),
		('Rome',14),
		('Florence',14),
		('Venice',14),
		('Milano',14),
		('Warsaw',15),
		('Krakow',15),
		('Varshava',15),
		('Opole',15),
		('Stockholm',16),
		('Borgholm',16),
		('Flen',16),
		('Filipstad',16),
		('Abrantes',17),
		('Esmoriz',17),
		('Faro',17),
		('Guarda',17)

--Testing purpose
SELECT CityName, Countries.CountryName FROM Cities
JOIN Countries ON Cities.CountryID = Countries.ID

--CREATING TABLE APPCREDENTIALS
CREATE TABLE AppCredentials(
ID INT PRIMARY KEY IDENTITY NOT NULL,
Username VARCHAR(40) NOT NULL,
EmailAddress VARCHAR(30) NOT NULL,
UserPassword Binary(64) NOT NULL
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

ALTER TABLE Users
ADD DateOfBirth DATETIME2 NOT NULL

ALTER TABLE AppCredentials
ADD UserID INT FOREIGN KEY REFERENCES Users(ID) NOT NULL

--Creating table with offers
CREATE TABLE ProductOffers(
ID INT PRIMARY KEY IDENTITY NOT NULL,
ProductID INT FOREIGN KEY REFERENCES Products(ID) NOT NULL,
UserID INT FOREIGN KEY REFERENCES Users(ID) NOT NULL,
IsOfferActive BIT DEFAULT(1),
DateOfOffer DATETIME2 DEFAULT(GETDATE())
)

ALTER TABLE ProductOffers
ADD CurrentAvaialbleQuantity SMALLINT  NOT NULL

--Adding table purchases made
CREATE TABLE PurcahsesMade(
ID INT PRIMARY KEY IDENTITY NOT NULL,
OfferID INT FOREIGN KEY REFERENCES ProductOffers(ID),
UserID INT FOREIGN KEY REFERENCES Users(ID)   --The user who made the purchase.
)

--Creating stored procedure for password and registration details
GO
CREATE PROCEDURE dbo.uspEnterAppCredentialsOnRegister @Email VARCHAR(30), @Username VARCHAR(40), @UserPassword VARCHAR(20)
AS

GO

--TO DO FINISH
SELECT * FROM AppCredentials

GO
CREATE OR ALTER PROCEDURE dbo.uspAddUserCredentials
    @Username VARCHAR(40), 
    @EmailAddress VARCHAR(30), 
    @PasswordString NVARCHAR(25) 
AS
BEGIN
        INSERT INTO AppCredentials (Username,EmailAddress,UserPassword,UserID)
        VALUES(@Username, @EmailAddress,HASHBYTES('SHA2_512', @PasswordString),0)
END


GO 
CREATE Procedure dbo.uspAddUserDetailsToUser
	@FirstName NVARCHAR(50),
	@MiddleName NVARCHAR(50),
	@LastName NVARCHAR(50),
	@Age SMALLINT,
	@Username VARCHAR(40), 
    @EmailAddress VARCHAR(30), 
    @PasswordString NVARCHAR(25), 
	@CityID INT,
	@DateOfBirth VARCHAR(20)
AS
BEGIN

DECLARE @AppCredentialsID INT;
SET @AppCredentialsID =  (SELECT ID FROM AppCredentials WHERE Username LIKE (@Username)
AND EmailAddress LIKE (@EmailAddress)
AND UserPassword LIKE (HASHBYTES('SHA2_512', @PasswordString)))

INSERT INTO Users (FirstName,MiddleName,LastName,Age,WalletAmount,AppCredential,CityID,DateOfBirth)
	VALUES
		(@FirstName,@MiddleName,@LastName,@Age,500,@AppCredentialsID,@CityID,Cast(@DateOfBirth as datetime2))
END

GO
CREATE PROCEDURE dbo.uspUpdateAppCredentialUserKey @Username VARCHAR(40), @EmailAddress VARCHAR(30)
AS 
BEGIN

DECLARE @CurrentAppCredentialsID INT;
SET @CurrentAppCredentialsID =  (SELECT ID FROM AppCredentials WHERE Username LIKE (@Username) AND EmailAddress LIKE (@EmailAddress))

DECLARE @UserIDWithTheAppCredentials INT
SET @UserIDWithTheAppCredentials = (SELECT ID FROM Users WHERE AppCredential =@CurrentAppCredentialsID)

UPDATE AppCredentials SET UserID = @UserIDWithTheAppCredentials WHERE ID = @CurrentAppCredentialsID

END

ALTER TABLE AppCredentials
DROP CONSTRAINT FK__AppCreden__UserI__4F7CD00D
DROP TABLE AppCredentials

ALTER TABLE Users 
DROP CONSTRAINT FK__Users__AppCreden__4BAC3F29


ALTER TABLE Users
ADD EmailAddress VARCHAR(30) NOT NULL

ALTER TABLE Users
ADD Username VARCHAR(20) NOT NULL

ALTER TABLE Users 
ADD UserPassword BINARY(64) NOT NULL

go
CREATE PROCEDURE dbo.uspInsertUser
@FirstName NVARCHAR(50),
	@MiddleName NVARCHAR(50),
	@LastName NVARCHAR(50),
	@Age SMALLINT,
	@Username VARCHAR(40), 
    @EmailAddress VARCHAR(30), 
    @PasswordString NVARCHAR(25), 
	@CityID INT,
	@DateOfBirth VARCHAR(20)
	AS
	BEGIN

	INSERT INTO Users (FirstName,MiddleName,LastName,Age,WalletAmount,CityID,DateOfBirth,Username,UserPassword,EmailAddress)
	VALUES
		(@FirstName,@MiddleName,@LastName,@Age,500,@CityID,Cast(@DateOfBirth as datetime2),@Username,HASHBYTES('SHA2_512', @PasswordString),@EmailAddress)

	END

	USE StockMarketDB
	SELECT * FROM Users
	ALTER TABLE Users
	DROP COLUMN AppCredential