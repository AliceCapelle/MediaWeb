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

	static {
		DataBase.ConnecterDataBase();
		Mediatheque.getInstance().setData(new MediathequeData());
		con = DataBase.getConnection();
	}

	public MediathequeData() {

	}

	// renvoie la liste de tous les documents de la biblioth�que
	@Override
	public List<Document> tousLesDocuments() throws SQLException {
		List<Document> doc = new ArrayList<Document>();
		Statement requeteDoc = con.createStatement();
		ResultSet tableResultat = requeteDoc
				.executeQuery("SELECT Iddoc, Type, Titre, Artiste, Annee, Iduser_emprunt FROM Document");
		if (!tableResultat.next())
			return null;
		else {
			do {
				Document d = new Docu(tableResultat.getInt("Iddoc"), tableResultat.getInt("Type"),
						tableResultat.getString("Titre"), tableResultat.getString("Artiste"),
						tableResultat.getInt("Annee"), tableResultat.getInt("Iduser_emprunt"));
				doc.add(d);
			} while (tableResultat.next());
		}
		return doc;
	}
	
	// renvoie la liste de tous les documents empruntable de la biblioth�que
		@Override
		public List<Document> tousLesDocumentsEmpruntable() throws SQLException {
			List<Document> doc = new ArrayList<Document>();
			Statement requeteDoc = con.createStatement();
			ResultSet tableResultat = requeteDoc
					.executeQuery("SELECT Iddoc, Type, Titre, Artiste, Annee, Iduser_emprunt FROM Document where Iduser_emprunt is null");
			if (!tableResultat.next())
				return null;
			else {
				do {
					Document d = new Docu(tableResultat.getInt("Iddoc"), tableResultat.getInt("Type"),
							tableResultat.getString("Titre"), tableResultat.getString("Artiste"),
							tableResultat.getInt("Annee"), tableResultat.getInt("Iduser_emprunt"));
					doc.add(d);
				} while (tableResultat.next());
			}
			return doc;
		}

	public List<Document> getDocuUser(int id) throws SQLException{
		List<Document> doc = new ArrayList<Document>();
		String querry = "SELECT Iddoc, Type, Titre, Artiste, Annee, Iduser_emprunt from Document where Iduser_emprunt = ?";
		PreparedStatement requete = con.prepareStatement(querry);
		requete.setInt(1, id);
		ResultSet tableResultat = requete.executeQuery();
		if (!tableResultat.next()) {
			return null;
		} 
		else {
			do {
				Document d = new Docu(tableResultat.getInt("Iddoc"), tableResultat.getInt("Type"),
						tableResultat.getString("Titre"), tableResultat.getString("Artiste"),
						tableResultat.getInt("Annee"), tableResultat.getInt("Iduser_emprunt"));
				doc.add(d);
			}while(tableResultat.next());
		}
		return doc;
	}
	
	
	
	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) throws SQLException {
		String querry = "SELECT Iduser, Type FROM Utilisateurs WHERE Nom = ? AND MotDePasse = ?";
		PreparedStatement requete = con.prepareStatement(querry);
		requete.setString(1, login);
		requete.setString(2, password);
		ResultSet tableResultat = requete.executeQuery();
		if (!tableResultat.next()) {
			return null;
		} else {
			Utilisateur u = new Utilisateur(tableResultat.getInt("Iduser"), password, login,
					tableResultat.getString("Type"));
			return u;
		}
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) throws SQLException {
		String querry = "SELECT Type, Titre, Artiste, Annee, Iduser_emprunt FROM Document WHERE Iddoc = ?";
		PreparedStatement requete = con.prepareStatement(querry);
		requete.setInt(1, numDocument);
		ResultSet tableResultat = requete.executeQuery();

		if (!tableResultat.next()) {
			return null;
		}

		else {
			Document d = new Docu(numDocument, tableResultat.getInt("Type"), tableResultat.getString("Titre"),
					tableResultat.getString("Artiste"), tableResultat.getInt("Annee"),
					tableResultat.getInt("Iduser_emprunt"));
			return d;

		}
	}

	@Override
	public void nouveauDocument(int type, String Titre, String Artiste, int Annee) throws SQLException {
		String querry = "INSERT INTO Document (Type, Titre, Artiste, Annee) VALUES(?,?,?,?)";
		PreparedStatement requete = con.prepareStatement(querry);
		requete.setInt(1, type);
		requete.setString(2, Titre);
		requete.setString(3, Artiste);
		requete.setInt(4, Annee);
		requete.executeUpdate();
	}

}
