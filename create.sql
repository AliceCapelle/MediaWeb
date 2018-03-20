USE projet_java;
drop table if exists Livre CASCADE;
drop table if exists Cd CASCADE;
drop table if exists Dvd CASCADE;
drop table if exists Utilisateurs CASCADE;

create table Utilisateurs(
	Iduser integer not null,
	Nom varchar(30) not null,
	MotDePasse varchar(30) not null,
	Type varchar(30) not null,
	primary key (Iduser)
);




/*create table Livre(
	Idlivre integer not null,
	Titre varchar(30) not null,
        Auteur varchar(30) not null,
	Edition varchar(30) not null,
	Annee integer not null,
	Iduser_emprunt_livre integer,
	primary key (Idlivre),
	foreign key(Iduser_emprunt_livre) references Utilisateurs(Iduser)
);

create table Cd(
	Idcd integer not null,
        Titre varchar(30) not null,
        Artiste varchar(30) not null,
	Annee integer not null,
	Iduser_emprunt_cd integer,
	primary key (Idcd),
	FOREIGN KEY (Iduser_emprunt_cd) REFERENCES Utilisateurs(Iduser)
);

create table Dvd(
	Iddvd integer not null,
        Titre varchar(30) not null,
        Realisateur varchar(30) not null,
	Acteur varchar(30) not null,
	Annee integer not null,
	Iduser_emprunt_dvd integer,
	primary key (Iddvd),
	FOREIGN KEY (Iduser_emprunt_dvd) REFERENCES Utilisateurs(Iduser)
);*/

create table Document(
	Iddoc integer not null,
	Type varchar(30) not null,
	Titre varchar(50) not null,
	Artiste varchar(30) not null,
	Annee integer,
	Iduser_emprunt integer,
	primary key (Iddoc),
	foreign key(Iduser_emprunt) references Utilisateurs(Iduser)
);



INSERT INTO Utilisateurs (Iduser, Nom, MotDePasse, Type) VALUES(1, 'Alice', 'password1', 'Bibliothecaire');
INSERT INTO Utilisateurs (Iduser, Nom, MotDePasse, Type) VALUES(2, 'Julie', 'password2', 'User');
INSERT INTO Document (Iddoc, Type, Titre, Artiste, Annee) VALUES(1, 'Livre', 'Bonjour Tristesse', 'Sagan', 1954);
INSERT INTO Document (Iddoc, Type, Titre, Artiste, Annee) VALUES(2, 'DVD', 'Garden State', 'Zach Braff', 2004);
INSERT INTO Document (Iddoc, Type, Titre, Artiste, Annee) VALUES(3, 'CD', 'MTV Unplugged in New Yord', 'Nirvana', 1994);
/*INSERT INTO Livre (Idlivre, Titre, Auteur, Edition, Annee) VALUES(1, 'Bonjour Tristesse', 'Sagan', 'Pocket', 1954);*/

