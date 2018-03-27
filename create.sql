drop table if exists Document CASCADE;
drop table if exists Utilisateurs CASCADE;

create table Utilisateurs(
	Iduser SERIAL primary key,
	Nom varchar(30) not null,
	MotDePasse varchar(30) not null,
	Type varchar(30) not null
);


create table Document(
	Iddoc SERIAL primary key,
	Type integer not null,
	Titre varchar(50) not null,
	Artiste varchar(30) not null,
	Annee integer,
	Iduser_emprunt integer,
	foreign key(Iduser_emprunt) references Utilisateurs(Iduser)
);



INSERT INTO Utilisateurs (Nom, MotDePasse, Type) VALUES('Alice', 'password1', 'Bibliothecaire');
INSERT INTO Utilisateurs (Nom, MotDePasse, Type) VALUES('Julie', 'password2', 'User');
INSERT INTO Document (Type, Titre, Artiste, Annee) VALUES(1, 'Bonjour Tristesse', 'Françoise Sagan', 1954);
INSERT INTO Document (Type, Titre, Artiste, Annee) VALUES(2, 'Garden State', 'Zach Braff', 2004);
INSERT INTO Document (Type, Titre, Artiste, Annee) VALUES(3, 'MTV Unplugged in New Yord', 'Nirvana', 1994);
INSERT INTO Document (Type, Titre, Artiste, Annee, Iduser_emprunt) VALUES(1, 'Harry Potter à l ecole des sorciers', 'J.K Rowling', 1997, 2);
INSERT INTO Document (Type, Titre, Artiste, Annee, Iduser_emprunt) VALUES(2, 'Le cinquieme element', 'Luc Besson', 2003, 2);


