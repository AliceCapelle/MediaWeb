package persistantdata;

import java.sql.SQLException;

import mediatheque.EmpruntException;
import mediatheque.Utilisateur;

public interface Document {
	void emprunter(Utilisateur a) throws EmpruntException, SQLException ;
	void retour() throws SQLException;
	Object[] affiche() ;
	String getTitre();
	String getArtiste();
	int getAnnee();
}
