package mediatheque;

import java.sql.SQLException;
import java.util.List;

public interface PersistentMediatheque {
// Jean-Fran�ois Brette 01/01/2018
	List<Document> tousLesDocuments() throws SQLException;
	
	List<Document> getDocuUser(int id) throws SQLException;

	Document getDocument(int numDocument) throws SQLException;

	Utilisateur getUser(String login, String password) throws SQLException;

	void nouveauDocument(int type, String Titre, String Artiste, int annee) throws SQLException;

	List<Document> tousLesDocumentsEmpruntable() throws SQLException;
	

}
