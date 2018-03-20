package mediatheque;

public class Utilisateur {
	private int id_user;
	private String password;
	private String nom;
	private String type;
	
	
	public Utilisateur(int id_user, String password, String nom, String type) {
		this.id_user = id_user;
		this.password = password;
		this.nom = nom;
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
