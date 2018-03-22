package persistantdata;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import mediatheque.*;

// classe mono-instance  dont l'unique instance n'est connue que de la bibliotheque
// via une auto-d�claration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-Fran�ois Brette 01/01/2018
	private static Connection con;
	

	private MediathequeData() {
		Mediatheque.getInstance().setData(new MediathequeData());
		DataBase.ConnecterDataBase();
		con = DataBase.getConnection();
;	}

	// renvoie la liste de tous les documents de la biblioth�que
	@Override
	public List<Document> tousLesDocuments() throws SQLException {
		List<Document> doc = new ArrayList<Document>();
		Statement requeteDoc = con.createStatement();
		ResultSet tableResultat = requeteDoc.executeQuery ("SELECT Iddoc, Type, Titre, Artiste, Annee, Iduser_emprunt FROM Document");
		if (!tableResultat.next())
			return null;
		else {
			do {
				Document d  = new Document(tableResultat.getInt("Iddoc"), tableResultat.getString("Type"), tableResultat.getString("Titre"), 
						tableResultat.getString("Artiste"), tableResultat.getInt("Annee"), tableResultat.getInt("Iduser_emprunt"));
				doc.add(d);
			}while (tableResultat.next());
		}
		con.close();
		return null;
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) throws SQLException {
		Statement requeteDoc = con.createStatement();
		ResultSet tableResultat = requeteDoc.executeQuery ("SELECT Iduser, Type FROM Utilisateurs WHERE Nom = " +login + "AND MotDePasse = " + password);
		if (!tableResultat.next()) {
			con.close();
			return null;}
		else {
			Utilisateur u = new Utilisateur(tableResultat.getInt("Iduser"), password, login, tableResultat.getString("Type"));
			con.close();
			return u;
		}
		
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) throws SQLException {
		Statement requeteDoc = con.createStatement();
		ResultSet tableResultat = requeteDoc.executeQuery("SELECT Type, Titre, Artiste, Annee, Iduser_emprunt FROM Document WHERE Iddoc = " + numDocument);
		if (!tableResultat.next()) {
			con.close();
			return null;
		}
			
		else {
			Document d  = new Document(numDocument, tableResultat.getString("Type"), tableResultat.getString("Titre"), 
					tableResultat.getString("Artiste"), tableResultat.getInt("Annee"), tableResultat.getInt("Iduser_emprunt"));
			con.close();
			return d;
			
		}
	}

	@Override
	public void nouveauDocument(int type, Object... args) {
		// args[0] -> le titre
		// args [1] --> l'auteur
		// etc...
	}
	

}
