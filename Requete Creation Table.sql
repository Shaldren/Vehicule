USE ManageVehicule

CREATE TABLE Vehicule(
	Identifiant INT IDENTITY NOT NULL,
	Marque NVARCHAR(100) NOT NULL,
	[Year] INT NOT NULL,
	Speed INT NOT NULL,
	Modele NVARCHAR(100) NOT NULL,
	Color NVARCHAR(100) NOT NULL,
	Price DECIMAL(8,2) NOT NULL
	
)

ALTER TABLE Vehicule ADD CONSTRAINT PK_Vehicule PRIMARY KEY (Identifiant);