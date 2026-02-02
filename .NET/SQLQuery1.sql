CREATE TABLE Student

(
	[No] INT NOT NULL identity PRIMARY KEY , 
    [Name] VARCHAR(50) NULL, 
    [Age] INT NULL, 
    [Email] VARCHAR(50) NULL, 
    [Addresss] VARCHAR(50) NULL,
	[IsEMailValidated] bit NULL
)
