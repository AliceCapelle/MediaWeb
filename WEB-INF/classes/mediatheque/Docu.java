// Jean-Fran�ois Brette 01/01/2018

package mediatheque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistantdata.DataBase;
import persistantdata.Document;

public class Docu implements Document{
// Jean-Fran�ois Brette 01/01/2018
	private int Iddoc;
	private int Type;
	private String Titre;
	private String Artiste;
	private int Annee;
	private int Iduser_emprunt;

	
	public Docu(int iddoc, int type, String titre, String artiste, int annee, int iduser_emprunt) {
		super();
		Iddoc = iddoc;
		Type = type;
		Titre = titre;
		Artiste = artiste;
		Annee = annee;
		Iduser_emprunt = iduser_emprunt;
	}


	@Override
	public void emprunter(Utilisateur a) throws EmpruntException, SQLException {
		//Faire l'exception si le livre est deja emprunte
		Connection con = DataBase.getConnection();
		String querry = "UPDATE Document set Iduser_emprunt= ? where Iddoc = ?";
		PreparedStatement requete = con.prepareStatement(querry);
		requete.setInt(1, a.getId_user());
		requete.setInt(2, this.Iddoc);
		ResultSet tableResultat = requete.executeQuery();
		
	}


	@Override
	public void retour() throws SQLException {
		Connection con = DataBase.getConnection();
		String querry = "UPDATE Document set Iduser_emprunt= null where Iddoc = ?";
		PreparedStatement requete = con.prepareStatement(querry);
		requete.setInt(1, this.Iddoc);
		ResultSet tableResultat = requete.executeQuery();
	}


	@Override
	public Object[] affiche() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getTitre() {
		return this.Titre;
	}


	@Override
	public String getArtiste() {
		return this.Artiste;
	}


	@Override
	public int getAnnee() {
		return this.Annee;
	}



	
	
}
