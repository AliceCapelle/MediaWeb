package mediatheque;

import java.sql.SQLException;

public interface Document {
	void emprunter(Utilisateur a) throws EmpruntException, SQLException ;
	void retour() throws SQLException;
	Object[] affiche() ;
	String getTitre();
	String getArtiste();
	String getType();
	int getIddoc();
	int getAnnee();
}
