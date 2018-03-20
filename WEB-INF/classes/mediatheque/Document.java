// Jean-Fran�ois Brette 01/01/2018

package mediatheque;

public class Document {
// Jean-Fran�ois Brette 01/01/2018
	private int Iddoc;
	private String Type;
	private String Titre;
	private String Artiste;
	private int Annee;
	private int Iduser_emprunt;

	
	public Document(int iddoc, String type, String titre, String artiste, int annee, int iduser_emprunt) {
		super();
		Iddoc = iddoc;
		Type = type;
		Titre = titre;
		Artiste = artiste;
		Annee = annee;
		Iduser_emprunt = iduser_emprunt;
	}
	void emprunter(Utilisateur a) throws EmpruntException {
		
	}
	void retour() {
	}
	Object[] affiche() {
		return null;
	}
	
}
